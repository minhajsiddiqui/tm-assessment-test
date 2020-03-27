package com.filesloader.tm.dao;

import java.util.List;

import com.filesloader.tm.entity.Task;

public interface ITaskDAO {

    /**
     * Find all tasks
     */
	public List<Task> findAll();
    
    /**
     * Find task by Id
     */
	public Task findById(int Id);
    
    /**
     * Insert Task
     * @return
     */
	public boolean save(Task task);
    
    /**
     * Delete Task by Id
     */
	public void deleteById(int Id);	
}