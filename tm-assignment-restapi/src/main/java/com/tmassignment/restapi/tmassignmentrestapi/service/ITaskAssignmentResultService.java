package com.tmassignment.restapi.tmassignmentrestapi.service;

import java.util.List;

import com.tmassignment.restapi.tmassignmentrestapi.entity.AssignmentResult;

public interface ITaskAssignmentResultService {

	public List<AssignmentResult> findAll();
	
	public AssignmentResult findById(int theId);
	
	public void save(List<AssignmentResult> theAssignmentResult);
	
	public void deleteById(int theId);
	
}
