package com.example.service;

import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDAO;
import com.example.entity.EmployeeEntity;
import com.example.entity.SkillSetEntity;
import com.example.model.Employee;
import com.example.model.SkillSet;


@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	private EmployeeDAO empDAO;
//	private SkillSetService skillsetService;
	
	@Override
	public Employee getEmployeesById(String empId) {
//		SkillSetEntity sse=skillsetService.getSkills(empId);
		return empDAO.getEmployeesById(empId);
	}
	@Override
	public String updateEmployeeById( Employee emp)
    {
		String message="";
//		skillsetService.get
//		skillsetService.updateSkill(empId, emp);
		String id=empDAO.updateEmployeeById(emp);
		if(id.equals(emp.getEmpId()))
		{
			message="Successfully Updated";
		}
		else
		{
			message="Id not found.Sorry!";
		}
		return message;
    } 
}

	

