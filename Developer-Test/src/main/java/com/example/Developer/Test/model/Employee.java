package com.example.Developer.Test.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

	@JsonProperty("id")
	private int id;
	@JsonProperty("employee_name")
	private String name;
	@JsonProperty("employee_salary")
	private double salary;
	@JsonProperty("employee_age")
	private Integer age;
	@JsonProperty("profile_image")
	private String profileImage;
	@JsonProperty("employee_annual_salary")
	private double annualSalary;

	public Employee(int id, String name, double salary, int age, String profileImage) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.profileImage = profileImage;
		this.annualSalary = salary * 12;
	}

	
	public Employee() {
		// Required default constructor
		super();
		this.annualSalary = salary * 12;
		
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public Integer getAge() {
		return age;
	}

	public double getAnnualSalary() {
		return this.salary * 12.0;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
