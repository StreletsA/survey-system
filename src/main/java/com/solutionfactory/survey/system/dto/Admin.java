package com.solutionfactory.survey.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
@Setter
@Getter
@AllArgsConstructor
public class Admin {

    @Id
    private String hash;

}
