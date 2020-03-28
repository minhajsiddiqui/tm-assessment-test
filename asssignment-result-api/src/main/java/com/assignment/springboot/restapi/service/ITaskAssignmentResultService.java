package com.assignment.springboot.restapi.service;

import java.util.List;

import com.assignment.springboot.restapi.entity.AssignmentResult;

public interface ITaskAssignmentResultService {

	public List<AssignmentResult> findAll();
	
	public AssignmentResult findById(int theId);
	
	public void save(AssignmentResult theAssignmentResult);
	
	public void deleteById(int theId);
	
}
