package com.assignment.springboot.restapi.dao;

import java.util.List;

import com.assignment.springboot.restapi.entity.AssignmentResult;

public interface ITaskAssignmentResultDAO {

	public List<AssignmentResult> findAll();
	
	public AssignmentResult findById(int theId);
	
	public void save(AssignmentResult theAssignmentResult);
	
	public void deleteById(int theId);
	
}
