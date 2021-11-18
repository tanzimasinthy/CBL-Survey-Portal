package com.cblSurveyPortal.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Grade {

    @Id
    private ObjectId id;
    private String name;
    private String value;
    private String status;

    public Grade() {
    }

    public Grade(ObjectId id, String name, String value, String status) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.status = status;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
