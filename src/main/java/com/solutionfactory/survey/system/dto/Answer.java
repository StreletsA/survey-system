package com.solutionfactory.survey.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Answer {

    private String id;
    private String text;
    private List<String> userIds;

    public Answer(){
        this.id = UUID.randomUUID().toString();
    }

    public Answer(String userId, String userAnswer){
        this.id = UUID.randomUUID().toString();
        this.text = userAnswer;
        userIds = new ArrayList<>();

        userIds.add(userId);
    }

}
