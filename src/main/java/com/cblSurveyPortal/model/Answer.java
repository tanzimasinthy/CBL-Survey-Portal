package com.cblSurveyPortal.model;

import com.cblSurveyPortal.dto.AnsDTO;
import com.cblSurveyPortal.enums.SurveyType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class Answer {
    @Id
    private ObjectId id;
    private Employee employee;
    private List<AnsDTO> ansList;
    private SurveyType surveyType;
    private String status;
    private Date date;

    public Answer() {
    }

    public Answer(ObjectId id, Employee employee, List<AnsDTO> ansList, SurveyType surveyType, String status, Date date) {
        this.id = id;
        this.employee = employee;
        this.ansList = ansList;
        this.surveyType = surveyType;
        this.status = status;
        this.date = date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
