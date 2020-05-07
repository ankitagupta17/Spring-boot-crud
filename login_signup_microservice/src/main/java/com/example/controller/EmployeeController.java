package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;
import com.example.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired	
	EmployeeService loginService;
	
	
	@RequestMapping(value = "/saveEmployee",method = RequestMethod.POST)
	public String saveEmployee(@RequestBody Employee emp)
	{		return loginService.saveEmployee(emp);
		
	}

}



