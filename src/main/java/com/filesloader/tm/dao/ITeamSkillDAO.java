package com.filesloader.tm.dao;

import java.util.List;

import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.TeamSkill;

public interface ITeamSkillDAO {

    /**
     * Find all team skills
     */
	public List<TeamSkill> findAll();
    
    /**
     * Find teamskill by Id
     */
	public Task findById(int Id);
    
    /**
     * Insert team skill
     */
	public boolean save(TeamSkill teamSkill);
    
    /**
     * Delete teamSkill by Id
     */
	public void deleteById(int Id);	
}