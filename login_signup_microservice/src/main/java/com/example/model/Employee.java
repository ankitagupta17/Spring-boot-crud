package com.example.model;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {
	private String empId;
	private String empName;
	private Integer empContact;
	private String empEmail;
	private String empPhoto;
	private List<SkillSet> skillSet;
	
	public List<SkillSet> getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(List<SkillSet> skillSet) {
		this.skillSet = skillSet;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empId, String empName, Integer empContact, String empEmail, String empPhoto) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empContact = empContact;
		this.empEmail = empEmail;
		this.empPhoto = empPhoto;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Integer getEmpContact() {
		return empContact;
	}
	public void setEmpContact(Integer empContact) {
		this.empContact = empContact;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPhoto() {
		return empPhoto;
	}
	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}
	
	

}