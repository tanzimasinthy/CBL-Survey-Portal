package com.cblSurveyPortal.dto;

import com.cblSurveyPortal.enums.SurveyType;

import java.io.Serializable;

public class AnsDTO implements Serializable {

    private static final long serialVersionUID = -7338047997792280285L;

    private String questionId;
    private String questionTitle;
    private String questionOption;
    private SurveyType surveyType;

    public AnsDTO() {
    }

    public AnsDTO(String questionId, String questionTitle, String questionOption, SurveyType surveyType) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.questionOption = questionOption;
        this.surveyType = surveyType;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionOption() {
        return questionOption;
    }

    public void setQuestionOption(String questionOption) {
        this.questionOption = questionOption;
    }

    public SurveyType getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(SurveyType surveyType) {
        this.surveyType = surveyType;
    }
}
