package com.amdocs.services;

import java.util.List;

import com.amdocs.entities.Employee;
public interface employeeServices {
	public List<Employee> getEmployees();
	
	public Employee getEmployee(long employeeId);
	
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployee(long parseLong);
}
