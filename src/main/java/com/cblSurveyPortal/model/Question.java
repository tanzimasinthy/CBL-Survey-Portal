package com.cblSurveyPortal.model;

import com.cblSurveyPortal.enums.SurveyType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.swing.*;
import java.util.List;

public class Question {
    @Id
    private ObjectId id;
    private String title;
    private SurveyType surveyType;
    private List<String> option;
    private String status;

    public Question() {
    }

    public Question(String status) {
        this.status = status;
    }

    public Question(ObjectId id, String title, SurveyType surveyType, List<String> option) {
        this.id = id;
        this.title = title;
        this.surveyType = surveyType;
        this.option = option;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SurveyType getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(SurveyType surveyType) {
        this.surveyType = surveyType;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
