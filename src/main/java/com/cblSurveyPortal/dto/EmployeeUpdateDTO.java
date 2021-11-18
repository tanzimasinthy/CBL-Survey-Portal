package com.cblSurveyPortal.dto;

import com.cblSurveyPortal.enums.Authority;
import com.cblSurveyPortal.enums.Gender;
import com.cblSurveyPortal.model.Department;
import com.cblSurveyPortal.model.Designation;
import com.cblSurveyPortal.model.Division;
import com.cblSurveyPortal.model.Grade;
import org.bson.types.ObjectId;

import java.util.Date;

public class EmployeeUpdateDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String password;
    private String email;
    private Grade grade;
    private Division division;
    private Department department;
    private int age;
    private Gender gender;
    private Date joiningDate;
    private String status;
    private Authority authority;

    public EmployeeUpdateDTO() {
    }

    public EmployeeUpdateDTO(String firstName, String lastName, String address, String password, String email, Grade grade, Division division, Department department, int age, Gender gender, Date joiningDate, String status, Authority authority) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
        this.grade = grade;
        this.division = division;
        this.department = department;
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

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
