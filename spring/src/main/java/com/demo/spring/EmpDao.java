package com.demo.spring;

import java.util.List;

public interface EmpDao {
	
	
	public String save(Emp e);
		
	public Emp findOne(int empId);
	
	public String delete(int empId);
	
	public List<Emp> getAll();
	
	public String saveAll(List<Emp> empList);
}
