package com.filesloader.tm.dao;

import java.util.List;

import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.Team;

public interface ITeamDAO {

    /**
     * Find all teams
     */
	public List<Team> findAll();
    
    /**
     * Find team by Id
     */
	public Task findById(int Id);
    
    /**
     * Insert team
     */
	public boolean save(Team team);
    
    /**
     * Delete team by Id
     */
	public void deleteById(int Id);	
}