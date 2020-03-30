package com.tmassignment.restapi.tmassignmentrestapi.service;

import java.util.List;

import com.tmassignment.restapi.tmassignmentrestapi.dao.ITaskAssignmentResultDAO;
import com.tmassignment.restapi.tmassignmentrestapi.entity.AssignmentResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskAssignmentResultServiceImpl implements ITaskAssignmentResultService {

	private ITaskAssignmentResultDAO assignmentResultDAO;

	@Autowired
	public TaskAssignmentResultServiceImpl(
			@Qualifier("taskAssignmentResultDAOImpl") ITaskAssignmentResultDAO theTaskAssignmentResultDAO) {
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
	public void save(List<AssignmentResult> theAssignmentResults) {
		for (AssignmentResult assignmentResult : theAssignmentResults) {
			assignmentResultDAO.save(assignmentResult);
		}
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		assignmentResultDAO.deleteById(theId);
	}

}
