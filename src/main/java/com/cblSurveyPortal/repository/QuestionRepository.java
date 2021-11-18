package com.cblSurveyPortal.repository;

import com.cblSurveyPortal.model.Employee;
import com.cblSurveyPortal.model.Question;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String > {
     Question findByTitleAndStatus(String title, String status);
     List<Question> findAllByStatus(String status);
     Question findByIdAndStatus(ObjectId id, String status);
     Question findByIdAndStatus(String questionId, String status);


}
