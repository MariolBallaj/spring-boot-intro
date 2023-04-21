package com.lhind.internship.springboot.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lhind.internship.springboot.model.entity.Employee;

@JsonSerialize
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;

    public EmployeeDTO() {}

    public EmployeeDTO(Employee employee) {
        this.setId(employee.getId());
        this.setFirstName(employee.getFirstName());
        this.setMiddleName(employee.getMiddleName());
        this.setLastName(employee.getLastName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
