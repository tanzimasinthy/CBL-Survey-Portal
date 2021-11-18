package com.cblSurveyPortal.dto;

import java.io.Serializable;

public class BranchCreateDTO implements Serializable {

    private static final long serialVersionUID = -7338047997792280285L;

    private String name;
    private String address;

    public BranchCreateDTO() {
    }

    public BranchCreateDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
