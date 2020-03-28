package com.filesloader.tm.dao;

import java.util.List;

import com.filesloader.tm.entity.TeamTask;

public interface ITeamTaskDAO {
     /**
     * Find all team skills
     */
	public List<TeamTask> findAll();
}