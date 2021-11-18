package com.cblSurveyPortal.dto;

import com.cblSurveyPortal.enums.SurveyType;

public class EmployeeLoginDTO {

    private String employeeId;
    private String surveyTypeId;

    public EmployeeLoginDTO() {
    }

    public EmployeeLoginDTO(String employeeId, String surveyTypeId) {
        this.employeeId = employeeId;
        this.surveyTypeId = surveyTypeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getSurveyTypeId() {
        return surveyTypeId;
    }

    public void setSurveyTypeId(String surveyTypeId) {
        this.surveyTypeId = surveyTypeId;
    }
}
