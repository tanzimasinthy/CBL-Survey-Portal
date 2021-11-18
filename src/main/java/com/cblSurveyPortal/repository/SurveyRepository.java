package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.model.Question;
import com.cblSurveyPortal.model.SurveyType;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends MongoRepository<SurveyType, String > {
     List<SurveyType> findAllByStatus(String status);
     SurveyType findByNameAndStatus(String name, String status);
     SurveyType findByIdAndStatus(ObjectId id, String status);


}
