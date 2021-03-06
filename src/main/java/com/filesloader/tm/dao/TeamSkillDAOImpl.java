package com.filesloader.tm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.TeamSkill;

import org.apache.log4j.Logger;

public class TeamSkillDAOImpl implements ITeamSkillDAO {
    final static Logger logger = Logger.getLogger(TeamDAOImpl.class);

    private EntityManager _entityManager;

    public TeamSkillDAOImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    @Override
    public List<TeamSkill> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task findById(int Id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean save(TeamSkill teamSkill) {
        EntityTransaction et = null;

        try {
            et = _entityManager.getTransaction();
            et.begin();

            _entityManager.persist(teamSkill);

            et.commit();

            return true;
        } catch (Exception e) {
            if (e != null) {
                et.rollback();
            }

            logger.error("Error while saving data => " + e);

            return false;

        }

    }

    @Override
    public void deleteById(int Id) {
        // TODO Auto-generated method stub

    }
	
}









