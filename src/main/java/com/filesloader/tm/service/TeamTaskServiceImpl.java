package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.dao.ITeamTaskDAO;
import com.filesloader.tm.entity.TeamTask;

public class TeamTaskServiceImpl implements ITeamTaskService {
    private ITeamTaskDAO _teamTaskDAO;

    public TeamTaskServiceImpl(ITeamTaskDAO teamTaskDAO) {
        _teamTaskDAO = teamTaskDAO;
    }

    @Override
    public List<TeamTask> findAll() {
        return _teamTaskDAO.findAll();
    }

}