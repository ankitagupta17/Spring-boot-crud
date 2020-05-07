package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.EmployeeEntity;
import com.example.entity.SkillSetEntity;
import com.example.model.Employee;
import com.example.model.SkillSet;



@Repository
public class EmployeeDAO {
		
	@PersistenceContext
	EntityManager entityManager;
	

	private RedisTemplate<String, Employee> redisTemplate;

    private HashOperations hashOperations;
    
    public  EmployeeDAO(RedisTemplate<String, Employee> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }
    
	public Employee getEmployeesById(String empId) {
//		String emplId = "100";
//		SkillSetEntity s=entityManager.find(SkillSetEntity.class, empId);
		EmployeeEntity t= entityManager.find(EmployeeEntity.class, empId);

			List<SkillSet> lSet=new ArrayList<SkillSet>();
			Employee e=new Employee();
			e.setEmpContact(t.getEmpContact());
			e.setEmpEmail(t.getEmpEmail());
			e.setEmpId(t.getEmpId());
			e.setEmpName(t.getEmpName());
			e.setEmpPhoto(t.getEmpPhoto());
			List<SkillSetEntity> l=t.getSkillSetEntity();
			for (SkillSetEntity skillSetEntity : l) {
				SkillSet s=new SkillSet();
				s.setEmpId(skillSetEntity.getEmpId());
				s.setSkillId(skillSetEntity.getSkillId());
				s.setSkillName(skillSetEntity.getSkillName());
				lSet.add(s);
			}
			e.setSkillSet(lSet);
			
		return e;
	
	
		
    }

	
	public String updateEmployeeById(Employee emp)
	{
		
		EmployeeEntity t= entityManager.find(EmployeeEntity.class, emp.getEmpId());
		
		t.setEmpContact(emp.getEmpContact());
		t.setEmpEmail(emp.getEmpEmail());
		t.setEmpId(emp.getEmpId());
		t.setEmpName(emp.getEmpName());
		t.setEmpPhoto(emp.getEmpPhoto());
		List<SkillSetEntity> lEntity=new ArrayList<SkillSetEntity>();
		List<SkillSet> s=emp.getSkillSet();
		for (SkillSet skillSet : s) {
			SkillSetEntity se=new SkillSetEntity();
			se.setEmpId(skillSet.getEmpId());
			se.setSkillId(skillSet.getSkillId());
			se.setSkillName(skillSet.getSkillName());
			entityManager.persist(se);
			lEntity.add(se);
		}
		t.setSkillSetEntity(lEntity);
		entityManager.persist(t);
		return t.getEmpId();
	}

	
}

