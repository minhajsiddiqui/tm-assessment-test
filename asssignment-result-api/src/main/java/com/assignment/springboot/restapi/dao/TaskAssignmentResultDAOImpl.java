package com.assignment.springboot.restapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.assignment.springboot.restapi.entity.AssignmentResult;
import com.assignment.springboot.restapi.entity.TeamTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskAssignmentResultDAOImpl implements ITaskAssignmentResultDAO {

	private final EntityManager entityManager;
	
	@Autowired
	public TaskAssignmentResultDAOImpl(final EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<AssignmentResult> findAll() {

		// create a query
		final Query theQuery = 
				entityManager.createQuery("from assignmentResult");
		
		// execute query and get result list
		final List<AssignmentResult> assignmentResults = theQuery.getResultList();
		
		// return the results		
		return assignmentResults;
	}

	@Override
	public void save(final AssignmentResult assignmentResult) {

		// save or update the assignmentResult
		final AssignmentResult dbAssignmentResult = entityManager.merge(assignmentResult);
		
		// update with id from db ... so we can get generated id for save/insert
		assignmentResult.setId(dbAssignmentResult.getId());
		
	}

	@Override
	public void deleteById(final int theId) {

		// delete object with primary key
		final Query theQuery = entityManager.createQuery(
							"delete from assignmentResult where id=:assignmentResultId");
		
		theQuery.setParameter("assignmentResultId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public AssignmentResult findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

}










