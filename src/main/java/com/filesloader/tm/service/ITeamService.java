package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.Team;

public interface ITeamService {

    public List<Team> findAll();

    public Team findById(int theId);

    public void save(Team theTeam);

    public void deleteById(int theId);
}