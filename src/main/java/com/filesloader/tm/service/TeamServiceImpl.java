package com.filesloader.tm.service;

import java.util.List;
import com.filesloader.tm.dao.ITeamDAO;
import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.Team;

public class TeamServiceImpl implements ITeamService {

    private ITeamDAO _teamDAO;

    public TeamServiceImpl(ITeamDAO teamDAO) {
        _teamDAO = teamDAO;
    }

    @Override
    public List<Team> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Team findById(int theId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Team theTeam) {
        // TODO Auto-generated method stub
        _teamDAO.save(theTeam);

    }

    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub

    }
}
