package com.cblSurveyPortal.dto;

public class DepartmentUpdateDTO {
    private String name;


    public DepartmentUpdateDTO() {
    }

    public DepartmentUpdateDTO(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
