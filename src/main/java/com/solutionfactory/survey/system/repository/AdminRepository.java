package com.solutionfactory.survey.system.repository;

import com.solutionfactory.survey.system.dto.Admin;
import com.solutionfactory.survey.system.dto.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {



}
