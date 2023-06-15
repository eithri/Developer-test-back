package com.example.Developer.Test.dto;

import java.util.List;

import com.example.Developer.Test.model.Employee;

public class EmployeesResponse {
    private List<Employee> data;

    public List<Employee> getData() {
        return data;
    }

    public void setData(List<Employee> data) {
        this.data = data;
    }
}