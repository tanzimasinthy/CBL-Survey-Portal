package com.cblSurveyPortal.dto;

import org.bson.types.ObjectId;

public class DivisionUpdateDTO {
    private String name;

    public DivisionUpdateDTO() {
    }

    public DivisionUpdateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
