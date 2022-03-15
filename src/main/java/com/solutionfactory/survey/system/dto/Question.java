package com.solutionfactory.survey.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class Question {

    private String id;

    private String text;
    private String type;
    private List<Answer> answers;

    public Question(){
        this.id = UUID.randomUUID().toString();
    }

    /*
    public Question(String text, String type, List<Answer> answers){
        this.text = text;
        this.type = type;
        this.answers = answers;
    }

    public Question(String text, String type){
        this.text = text;
        this.type = type;
        this.answers = new ArrayList<>();
    }
     */

    public void addUserAnswer(String userId, String userAnswer) throws IllegalStateException{
        if(type.equals("text")){
            answers.add(new Answer(userId, userAnswer));
            return;
        }

        for(Answer answer : answers){

            if(answer.getId().equals(userAnswer)){
                answer.getUserIds().add(userId);
                return;
            }

        }

        throw new IllegalStateException("Answer with id " + userAnswer + " not found");
    }

}
