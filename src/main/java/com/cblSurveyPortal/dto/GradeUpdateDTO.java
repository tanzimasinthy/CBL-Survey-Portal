package com.cblSurveyPortal.dto;

import org.bson.types.ObjectId;

public class GradeUpdateDTO {
    private String name;
    private String value;

    public GradeUpdateDTO() {
    }

    public GradeUpdateDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

