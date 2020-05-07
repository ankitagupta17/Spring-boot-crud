package com.example.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.model.SkillSet;

@Entity
@Table(name = "emp")
public class EmployeeEntity implements Serializable {
	@Id
	private String empId;
	private String empName;
	private Integer empContact;
	private String empEmail;
	private String empPhoto;
	
	@OneToMany(mappedBy ="empId")
	private List<SkillSetEntity> skillSetEntity;
	

	
	/**
	 * @param empId
	 * @param empName
	 * @param empContact
	 * @param empEmail
	 * @param empPhoto
	 * @param skillSetEntity
	 */
	public EmployeeEntity(String empId, String empName, Integer empContact, String empEmail, String empPhoto,
			List<SkillSetEntity> skillSetEntity) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empContact = empContact;
		this.empEmail = empEmail;
		this.empPhoto = empPhoto;
		this.skillSetEntity = skillSetEntity;
	}
	public EmployeeEntity() {
		super();
	}
	public List<SkillSetEntity> getSkillSetEntity() {
		return skillSetEntity;
	}
	public void setSkillSetEntity(List<SkillSetEntity> skillSetEntity) {
		this.skillSetEntity = skillSetEntity;
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