package com.cblSurveyPortal.dto;

public class SurveyCreateDTO {

    private String name;

    public SurveyCreateDTO() {
    }

    public SurveyCreateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
