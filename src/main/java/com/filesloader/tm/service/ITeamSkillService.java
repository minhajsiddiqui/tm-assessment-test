package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.entity.TeamSkill;

public interface ITeamSkillService {

    public List<TeamSkill> findAll();

    public TeamSkill findById(int theId);

    public void save(TeamSkill theTeamSkill);

    public void deleteById(int theId);

}