package com.filesloader.tm.controller;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.filesloader.tm.contracts.Constants;
import com.filesloader.tm.contracts.IFileController;
import com.filesloader.tm.dao.TaskDAOImpl;
import com.filesloader.tm.dao.TeamDAOImpl;
import com.filesloader.tm.dao.TeamSkillDAOImpl;
import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.Team;
import com.filesloader.tm.entity.TeamSkill;
import com.filesloader.tm.service.ITaskService;
import com.filesloader.tm.service.ITeamService;
import com.filesloader.tm.service.ITeamSkillService;
import com.filesloader.tm.service.TaskServiceImpl;
import com.filesloader.tm.service.TeamServiceImpl;
import com.filesloader.tm.service.TeamSkillServiceImpl;

public class LoaderDaemonController implements IFileController {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("teamDb");

    private EntityManager _entityManager;
    private ITaskService _taskService;
    private ITeamService _teamService;
    private ITeamSkillService _teamSkillService;

    public LoaderDaemonController() {

        _entityManager = entityManagerFactory.createEntityManager();

        // TODO: Use DI to avoid such instantiation.
        _taskService = new TaskServiceImpl(new TaskDAOImpl(_entityManager));
        _teamService = new TeamServiceImpl(new TeamDAOImpl(_entityManager));
        _teamSkillService = new TeamSkillServiceImpl(new TeamSkillDAOImpl(_entityManager));
    }

    @Override
    public void insertFileIntoDB(Map<String, List<String[]>> fileContent) {
        fileContent.forEach((k, v) -> {
            switch (k) {
                case Constants.FILE_NAME_TASK:
                    insertTaskData(fileContent.get(Constants.FILE_NAME_TASK));
                    break;

                case Constants.FILE_NAME_TEAM:
                    insertTeamData(fileContent.get(Constants.FILE_NAME_TEAM));
                    break;

                case Constants.FILE_NAME_TEAMSKILL:
                    insertTeamSkillData(fileContent.get(Constants.FILE_NAME_TEAMSKILL));
                    break;
            }
        });

        // insertTaskData(filesContent.get(Constants.FILE_NAME_TEAMSKILL));
        // _entityManager.close();
        // entityManagerFactory.close();
    }

    private void insertTaskData(List<String[]> taskData) {
        // TODO: Enable bulk insert logic in future.
        for (String[] content : taskData) {
            Task task = new Task();

            task.setTaskId(content[0]);
            task.setSkill(content[1]);

            _taskService.save(task);
        }
    }

    private void insertTeamData(List<String[]> teamData) {
        // TODO: Enable bulk insert logic in future.
        for (String[] content : teamData) {
            Team team = new Team();

            team.setTeamId(content[0]);

            _teamService.save(team);
        }
    }

    private void insertTeamSkillData(List<String[]> teamSkillData) {
        // TODO: Enable bulk insert logic in future.
        for (String[] content : teamSkillData) {
            TeamSkill teamSkill = new TeamSkill();

            teamSkill.setTeamId(content[0]);
            teamSkill.setSkill(content[1]);
            
            _teamSkillService.save(teamSkill);
        }
    }

}