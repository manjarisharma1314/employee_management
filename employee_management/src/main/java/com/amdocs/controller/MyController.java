package com.amdocs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.entities.Employee;
import com.amdocs.services.employeeServices;

@RestController
public class MyController {
	@Autowired 
	private employeeServices es;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome";
	}
	
	//get emp
	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> employees = es.getEmployees();
		return new ResponseEntity<> (employees,HttpStatus.OK);
	}
    
	@GetMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable ("employeeId") Long employeeId) {
		Employee e=es.getEmployee(employeeId);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = es.addEmployee(employee);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("employeeId")Long employeeId,@RequestBody Employee employee) {
		employee.setId(employeeId);
		Employee updatedEmployee = es.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<HttpStatus> deleteEmployee
		(@PathVariable String employeeId){
		try {
			this.es.deleteEmployee(Long.parseLong(employeeId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

