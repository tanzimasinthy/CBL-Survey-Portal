package com.cblSurveyPortal.dto;

import com.cblSurveyPortal.enums.Gender;
import com.cblSurveyPortal.model.Department;
import com.cblSurveyPortal.model.Designation;
import com.cblSurveyPortal.model.Division;
import com.cblSurveyPortal.model.Grade;

import java.util.Date;

public class RegistrationDTO {
    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private String email;
    private String gradeId;
    private String divisionId;
    private String departmentId;
    private String employeeId;
    private int age;
    private Gender gender;
    private Date joiningDate;
    private String status;
    private String authority;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String firstName, String lastName, String address, String password, String email, String gradeId, String divisionId, String departmentId, String employeeId, int age, Gender gender, Date joiningDate, String status, String authority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
        this.gradeId = gradeId;
        this.divisionId = divisionId;
        this.departmentId = departmentId;
        this.employeeId = employeeId;
        this.age = age;
        this.gender = gender;
        this.joiningDate = joiningDate;
        this.status = status;
        this.authority = authority;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
