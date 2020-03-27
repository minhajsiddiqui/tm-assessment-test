package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.dao.ITeamSkillDAO;
import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.TeamSkill;

import org.apache.log4j.Logger;

public class TeamSkillServiceImpl implements ITeamSkillService {
    final static Logger logger = Logger.getLogger(TeamSkillServiceImpl.class);

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
         boolean result = _teamSkillDAO.save(theTeamSkill);

         if(result){
            logger.info("Saved data => "+ theTeamSkill.getTeamId());
            return;
         } 

         logger.error("Error while saving data => "+ theTeamSkill.getTeamId());
    }

    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub

    }
}





