package com.cblSurveyPortal.dto;

import java.io.Serializable;

public class DivisionCreateDTO implements Serializable {

    private static final long serialVersionUID = -7338047997792280285L;

    private String name;

    public DivisionCreateDTO() {
    }

    public DivisionCreateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
