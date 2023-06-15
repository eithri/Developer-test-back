package com.example.Developer.Test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Developer.Test.dto.EmployeeResponse;
import com.example.Developer.Test.dto.EmployeesResponse;
import com.example.Developer.Test.model.Employee;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/employees")
public class ControllerEmployee {
	
	private final RestTemplate restTemplate;
	private Gson gson = new Gson();
	
	private static final String URL = "https://dummy.restapiexample.com/api/v1/employee/";
	
	public ControllerEmployee (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public ResponseEntity<String> getEmployees() {
    	try {
    		ResponseEntity<EmployeesResponse> response = restTemplate.getForEntity("https://dummy.restapiexample.com/api/v1/employees", EmployeesResponse.class);
    		List<Employee> employees = response.getBody().getData();
    		// Loop through each employee and update their annual salary
    		for (Employee employee : employees) {
    			employee.setAnnualSalary(employee.getSalary() * 12);
    		}
    		return new ResponseEntity<>(gson.toJson(employees), HttpStatus.OK);			
		} catch (Exception e) {
			return getErrorMessage(e);
		}
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable String id) {
    	try {
    		
    		EmployeeResponse employeeResponse = restTemplate.getForObject(URL+ "/" + id, EmployeeResponse.class);
    		Employee employee = employeeResponse.getData();
    		employee.setAnnualSalary(employee.getSalary() * 12); // set annual salary to salary * 12
    		return new ResponseEntity<>(gson.toJson(employee), HttpStatus.OK);			
		} catch (Exception e) {
			return getErrorMessage(e);

		}
    }
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResponseEntity<String> getErrorMessage(Exception e) {
		ResponseEntity resp = null;
		String cause = e.getCause() != null ? e.getCause().toString().replace("\n", "-").replace("\r", "-") : "";
		String cause2 = e.toString() != null ? e.toString().replace("\n", "-").replace("\r", "-") : "";

		resp = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("{\"type\":\"" + e.getClass().getSimpleName() + "\",\"message\":\"" + e.getMessage()
						+ "\",\"cause\":\"" + cause + "\",\"string\":\"" + cause2 + "\"}");
		return resp;
	}
}
