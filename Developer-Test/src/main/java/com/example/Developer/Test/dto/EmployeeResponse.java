package com.example.Developer.Test.dto;

import com.example.Developer.Test.model.Employee;

public class EmployeeResponse {
	
    private String status;
	private Employee data;

	public String getStatus() {
		return status;
	}
	public Employee getData() {
		return data;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setData(Employee data) {
		this.data = data;
	}
}