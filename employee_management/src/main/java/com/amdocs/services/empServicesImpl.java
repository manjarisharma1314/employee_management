package com.amdocs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.dao.EmployeeDao;
import com.amdocs.entities.Employee;

@Service
public class empServicesImpl implements employeeServices {
	@Autowired 
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getEmployees(){
		return employeeDao.findAll();
		
	}
	@Override
	public Employee addEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}
	
	@Override 
	public Employee getEmployee(long employeeId) {
		return employeeDao.findById(employeeId).get();
	}
	
	@Override
	public Employee updateEmployee (Employee employee) {
		employeeDao.save(employee);
		return employee;
	}
	
	@Override
	public void deleteEmployee(long parseLong) {
		Employee entity=employeeDao.getOne(parseLong);
		employeeDao.delete(entity);
	}

}
