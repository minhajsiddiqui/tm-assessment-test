package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.entity.TeamTask;

public interface ITeamTaskService {
    public List<TeamTask> findAll();
}