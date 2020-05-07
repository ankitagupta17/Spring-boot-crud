package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tracks")
public class SkillSetEntity {
	@Id
	private String skillId;
	private String skillName;
	private String empId;

	
/**
	 * @param skillId
	 * @param skillName
	 * @param empId
	 * @param employeeEntity
	 */
	public SkillSetEntity(String skillId, String skillName, String empId) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.empId = empId;
//		this.employeeEntity = employeeEntity;
	}
	
	
	
/**
 * 
 */
public SkillSetEntity() {
	super();
	// TODO Auto-generated constructor stub
}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
