package com.example.controller;

import java.util.List;

import org.apache.el.stream.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EmployeeDAO;
import com.example.entity.EmployeeEntity;
import com.example.model.Employee;
import com.example.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired	
	EmployeeService empService;
	
	

	@GetMapping(value = "/getEmployeeByID/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable String id) {
		Employee employee =empService.getEmployeesById(id);
		return ResponseEntity.ok().body(employee);
	}
	
	@RequestMapping(value = "/updateEmployeeById/{id}",method = RequestMethod.PUT)
	public ResponseEntity<String> updateEmployeeById(@RequestBody Employee emp)
	{		
			String response =empService.updateEmployeeById(emp);
			return ResponseEntity.ok().body(response);
		
	}
	
}
