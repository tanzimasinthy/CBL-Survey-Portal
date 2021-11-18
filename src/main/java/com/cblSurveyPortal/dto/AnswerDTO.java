package com.cblSurveyPortal.dto;

import com.cblSurveyPortal.enums.SurveyType;


import java.util.Date;
import java.util.List;

public class AnswerDTO {
    private List<AnsDTO> ansList;
    private SurveyType surveyType;
    private Date date;

    public AnswerDTO() {
    }

    public AnswerDTO(List<AnsDTO> ansList, SurveyType surveyType, Date date) {
        this.ansList = ansList;
        this.surveyType = surveyType;
        this.date = date;
    }

    public List<AnsDTO> getAnsList() {
        return ansList;
    }

    public void setAnsList(List<AnsDTO> ansList) {
        this.ansList = ansList;
    }

    public SurveyType getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(SurveyType surveyType) {
        this.surveyType = surveyType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
