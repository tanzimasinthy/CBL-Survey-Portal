package com.cblSurveyPortal.dto;

import com.cblSurveyPortal.enums.SurveyType;

import java.io.Serializable;
import java.util.List;

public class QuestionUpdateDTO implements Serializable {
    private static final long serialVersionUID = -7338047997792280285L;

    private String title;
    private SurveyType surveyType;
    private List<String> options;

    public QuestionUpdateDTO() {
    }

    public QuestionUpdateDTO(String title, SurveyType surveyType, List<String> options) {
        this.title = title;
        this.surveyType = surveyType;
        this.options = options;
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

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
