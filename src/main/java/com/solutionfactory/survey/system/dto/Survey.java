package com.solutionfactory.survey.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "surveys")
@Setter
@Getter
@AllArgsConstructor
public class Survey {

    @Id
    private String id;

    private String name;

    @JsonIgnore
    private String startTime;

    private String finishTime;
    private String description;
    private List<Question> questions;

    public Survey(){
        startTime = String.valueOf(System.currentTimeMillis());
    }

    public String toString(){
        return name + " " + startTime + " " + finishTime + " " + description;
    }

}
