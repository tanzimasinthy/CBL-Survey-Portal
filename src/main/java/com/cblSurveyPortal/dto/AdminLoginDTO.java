package com.cblSurveyPortal.dto;

import com.cblSurveyPortal.enums.SurveyType;

public class AdminLoginDTO {
    private String username;
    private String password;

    public AdminLoginDTO() {
    }

    public AdminLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
