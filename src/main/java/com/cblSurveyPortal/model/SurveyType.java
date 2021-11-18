package com.cblSurveyPortal.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class SurveyType {

    @Id
    private ObjectId id;
    private String name;
    private Boolean active;
    private String status;

    public SurveyType() {
    }

    public SurveyType(ObjectId id, String name, Boolean active, String status) {
        this.id = id;
        this.name = name;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
