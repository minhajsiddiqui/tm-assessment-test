package com.filesloader.tm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.filesloader.tm.entity.TeamTask;
import org.apache.log4j.Logger;

public class TeamTaskDAOImpl implements ITeamTaskDAO {

    final static Logger logger = Logger.getLogger(TeamTaskDAOImpl.class);

    private EntityManager _entityManager;

    public TeamTaskDAOImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    @Override
    public List<TeamTask> findAll() {

        String query = "SELECT Distinct tk.teamId, t.taskId FROM TeamSkill tk INNER JOIN Task t On tk.skill = t.skill";

        Query queryTeamTask = _entityManager.createQuery(query);

        List<TeamTask> ttList = new ArrayList<TeamTask>();

        try {


            //TODO: Something is wrong here. Need to fix it.
            var result = queryTeamTask.getResultList();

            // for (Object value : result)
            // {
            //     var teamTask = new TeamTask();
            //     var a = (String[])value;

            //     ttList.add(teamTask);
            // }

            return ttList;

        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e);

            return null;
        }
    }
}