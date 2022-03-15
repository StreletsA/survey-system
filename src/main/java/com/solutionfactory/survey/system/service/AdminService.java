package com.solutionfactory.survey.system.service;

import com.solutionfactory.survey.system.dto.Admin;
import com.solutionfactory.survey.system.dto.Survey;
import com.solutionfactory.survey.system.repository.AdminRepository;
import com.solutionfactory.survey.system.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private SurveyRepository surveyRepository;
    @Autowired
    private AdminRepository adminRepository;

    public void addSurvey(String hash, Survey survey) throws IllegalStateException{

        if(adminRepository.findById(hash).isEmpty())
            throw new IllegalStateException("User is not admin!");

        try{
            Optional<Survey> surveyOptional = surveyRepository.findById(survey.getId());
            Survey oldSurvey = surveyOptional.get();
            surveyRepository.deleteById(survey.getId());

            survey.setStartTime(oldSurvey.getStartTime());

            surveyRepository.insert(survey);
        }catch (Exception e){
            surveyRepository.insert(survey);
        }

    }

}
