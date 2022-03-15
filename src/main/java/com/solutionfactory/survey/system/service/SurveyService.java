package com.solutionfactory.survey.system.service;

import com.solutionfactory.survey.system.dto.Answer;
import com.solutionfactory.survey.system.dto.Question;
import com.solutionfactory.survey.system.dto.Survey;
import com.solutionfactory.survey.system.repository.SurveyRepository;
import com.solutionfactory.survey.system.request.UserAnswerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> getAllSurveys(){

        return surveyRepository.findAll();

    }

    public List<Survey> getSurveysForUserId(String userId){

        List<Survey> surveys = getAllSurveys();
        List<Survey> res = new ArrayList<>();

        for (Survey survey : surveys){

            if (survey.getQuestions() == null)
                continue;

            for (Question question : survey.getQuestions()){

                if (question.getAnswers() == null)
                    continue;

                for (Answer answer : question.getAnswers()){

                    if (answer.getUserIds() == null)
                        continue;

                    if(answer.getUserIds().contains(userId))
                        res.add(survey);

                }

            }

        }

        return res;
    }

    public void toAnswer(String userId, String surveyId, String questionId, String userAnswer) throws IllegalStateException{

        Optional<Survey> surveyOptional = surveyRepository.findById(surveyId);

        if(surveyOptional.isEmpty())
            throw new IllegalStateException("Survey with id " + surveyId + " not found");

        Survey survey = surveyOptional.get();

        Optional<Question> questionOptional = survey.getQuestions().stream().filter(q -> q.getId().equals(questionId)).findFirst();

        if(questionOptional.isEmpty())
            throw new IllegalStateException("Question with id " + questionId + " not found");

        Question question = questionOptional.get();

        question.addUserAnswer(userId, userAnswer);

        survey.getQuestions().removeIf(q -> q.getId().equals(questionId));
        survey.getQuestions().add(question);

        surveyRepository.deleteById(surveyId);
        surveyRepository.insert(survey);
    }

    public void toAnswer(UserAnswerRequest userAnswerRequest){
        toAnswer(userAnswerRequest.getUserId(),
                userAnswerRequest.getSurveyId(),
                userAnswerRequest.getQuestionId(),
                userAnswerRequest.getUserAnswer());
    }

}
