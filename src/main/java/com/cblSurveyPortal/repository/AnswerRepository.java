package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.enums.SurveyType;
import com.cblSurveyPortal.model.Answer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, String> {
    Answer findByIdAndStatus(ObjectId id, String status);
    Answer findBySurveyTypeAndEmployeeIdInAndStatus(SurveyType surveyType, ObjectId id, String status);
    List<Answer> findBySurveyTypeAndStatus(SurveyType surveyType, String status);
    List<Answer> findAllByStatus(String status);

}
