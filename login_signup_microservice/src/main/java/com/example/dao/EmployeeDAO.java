package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.EmployeeEntity;
import com.example.entity.LoginEntity;
import com.example.entity.SkillSetEntity;
import com.example.model.Employee;
import com.example.model.Login;
import com.example.model.SkillSet;


@Repository
public class EmployeeDAO{
	@PersistenceContext
	EntityManager entityManager;
	
	private RedisTemplate<String, Employee> redisTemplate;

    private HashOperations hashOperations;
    
    public  EmployeeDAO(RedisTemplate<String, Employee> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

	
	public String saveEmployee(Employee emp)
	{
		EmployeeEntity empEntityObj=new EmployeeEntity();
		empEntityObj.setEmpContact(emp.getEmpContact());
		empEntityObj.setEmpEmail(emp.getEmpEmail());
		empEntityObj.setEmpId(emp.getEmpId());
		empEntityObj.setEmpName(emp.getEmpName());
		empEntityObj.setEmpPhoto(emp.getEmpPhoto());
		
		entityManager.persist(empEntityObj);
		  byte[] array = new byte[10]; // length is bounded by 10
		    new Random().nextBytes(array);
		    String generatedString = new String(array);
		LoginEntity lentity=new LoginEntity();
		lentity.setContact(emp.getEmpContact());
		lentity.setLoginId(emp.getEmpId());
		lentity.setPassword(generatedString);
		entityManager.persist(lentity);
		
		List<SkillSetEntity> slist=new ArrayList<SkillSetEntity>();
		List<SkillSet> t=emp.getSkillSet();
		for (SkillSet skillSet : t) {
			SkillSetEntity sentity=new SkillSetEntity();
			sentity.setEmpId(emp.getEmpId());
			sentity.setSkillId(skillSet.getSkillId());
			sentity.setSkillName(skillSet.getSkillName());
			entityManager.persist(sentity);
			slist.add(sentity);
		}
		empEntityObj.setSkillSetEntity(slist);
		entityManager.persist(empEntityObj);
		return "Data is successfully inserted";
	}
}

