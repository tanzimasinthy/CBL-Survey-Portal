package com.cblSurveyPortal.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Department {
    @Id
    private ObjectId id;
    private String name;
    private String status;

    public Department() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
