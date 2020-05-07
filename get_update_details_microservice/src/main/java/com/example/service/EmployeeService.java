package com.example.service;

import com.example.entity.EmployeeEntity;
import com.example.model.Employee;

public interface EmployeeService {
	
	public Employee getEmployeesById(String empId);
	
	public String updateEmployeeById(Employee emp);

}

