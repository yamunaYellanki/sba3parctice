package com.demo.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public String save(Emp e) {
		
		em.persist(e);
		return "Emp Saved";
	}

	@Override
	public Emp findOne(int empId) {
		
		Emp e = em.find(Emp.class, empId);
		return e;
	}
	
	@Override
	public String delete(int empId) {
		
		Emp e = em.find(Emp.class, empId);
		if(e != null)
		{
			em.remove(e);
			return "EMP Deleted";
		}
		return "No Employee by this ID";
	}

	@Override
	public List<Emp> getAll() {

		Query q = em.createQuery("select e from Emp e");
		List<Emp> empList = q.getResultList();
		return empList;
	}

	@Override
	public String saveAll(List<Emp> empList) {
		// TODO Auto-generated method stub
		return null;
	}

}
