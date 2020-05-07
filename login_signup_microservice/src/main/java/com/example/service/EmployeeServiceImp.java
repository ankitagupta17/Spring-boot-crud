package com.example.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;
@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{

	
	@Autowired
	private EmployeeDAO loginDAO;
	

	public String saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return loginDAO.saveEmployee(emp);
	}

}
