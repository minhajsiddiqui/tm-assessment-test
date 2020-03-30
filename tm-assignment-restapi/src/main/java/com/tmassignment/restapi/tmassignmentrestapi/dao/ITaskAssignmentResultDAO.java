package com.tmassignment.restapi.tmassignmentrestapi.dao;

import java.util.List;

import com.tmassignment.restapi.tmassignmentrestapi.entity.AssignmentResult;

public interface ITaskAssignmentResultDAO {

	public List<AssignmentResult> findAll();

	public AssignmentResult findById(int theId);

	public void save(AssignmentResult theAssignmentResult);

	public void deleteById(int theId);

}
