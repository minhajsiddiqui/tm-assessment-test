package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.dao.ITaskDAO;
import com.filesloader.tm.entity.Task;

public class TaskServiceImpl implements ITaskService {

	private ITaskDAO taskDAO;

	public TaskServiceImpl(ITaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Task theTask) {
		// TODO: We can have retry logic here.
		taskDAO.save(theTask);
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}





