package com.assignment.springboot.restapi.service;

import java.util.List;

import com.assignment.springboot.restapi.dao.ITaskAssignmentResultDAO;
import com.assignment.springboot.restapi.entity.AssignmentResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskAssignmentResultServiceImpl implements ITaskAssignmentResultService {

	private ITaskAssignmentResultDAO assignmentResultDAO;
	
	@Autowired
	public TaskAssignmentResultServiceImpl(@Qualifier("taskAssignmentResultDAOImpl") ITaskAssignmentResultDAO theTaskAssignmentResultDAO) {
		assignmentResultDAO = theTaskAssignmentResultDAO;
	}
	
	@Override
	@Transactional
	public List<AssignmentResult> findAll() {
		return assignmentResultDAO.findAll();
	}

	@Override
	@Transactional
	public AssignmentResult findById(int theId) {
		return assignmentResultDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(AssignmentResult theassignmentResult) {
		assignmentResultDAO.save(theassignmentResult);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		assignmentResultDAO.deleteById(theId);
	}

}






