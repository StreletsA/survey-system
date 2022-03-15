package com.solutionfactory.survey.system.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAnswerRequest {

    private String userId;
    private String surveyId;
    private String questionId;
    private String userAnswer;

}
