package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.dao.ITeamSkillDAO;
import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.TeamSkill;

public class TeamSkillServiceImpl implements ITeamSkillService {

    private ITeamSkillDAO _teamSkillDAO;

    public TeamSkillServiceImpl(ITeamSkillDAO teamSkillDAO) {
        _teamSkillDAO = teamSkillDAO;
    }

    @Override
    public List<TeamSkill> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TeamSkill findById(int theId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(TeamSkill theTeamSkill) {
        _teamSkillDAO.save(theTeamSkill);
    }

    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub

    }
}





