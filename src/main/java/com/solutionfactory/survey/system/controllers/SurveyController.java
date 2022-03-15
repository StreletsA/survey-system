package com.solutionfactory.survey.system.controllers;

import com.solutionfactory.survey.system.dto.Survey;
import com.solutionfactory.survey.system.request.UserAnswerRequest;
import com.solutionfactory.survey.system.service.AdminService;
import com.solutionfactory.survey.system.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;
    @Autowired
    private AdminService adminService;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Survey> getSurveys(){
        return surveyService.getAllSurveys();
    }


    @GetMapping(value="/my/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Survey> getSurveysById(@RequestParam("userId") String userId){
        return surveyService.getSurveysForUserId(userId);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addSurvey(@RequestBody Survey survey, @RequestHeader("Authorization") String authorization){
        adminService.addSurvey(authorization, survey);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void toAnswer(@RequestBody UserAnswerRequest userAnswerRequest){

        surveyService.toAnswer(userAnswerRequest);
    }

}
