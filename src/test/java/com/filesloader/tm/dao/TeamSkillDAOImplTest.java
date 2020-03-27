package com.filesloader.tm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.TeamSkill;

@RunWith(MockitoJUnitRunner.class)
public class TeamSkillDAOImplTest {

    @Mock
    EntityManager mockedEntityManager;

    @Mock
    EntityTransaction mockedEntityTransaction;

    @Test
    public void save_withSuccessfulPersistence_ReturnsTrue() {

        // Arrange        
        ITeamSkillDAO teamSkillDAOImpl = new TeamSkillDAOImpl(mockedEntityManager);

        TeamSkill teamSkill = new TeamSkill();

        teamSkill.setSkill("Skill1");
        teamSkill.setTeamId("Team1");

        when(mockedEntityManager.getTransaction()).thenReturn(mockedEntityTransaction);        

        // Act
        boolean result = teamSkillDAOImpl.save(teamSkill);       
        
        // Assert
        assertTrue(result);
    }

    @Test
    public void save_withUnSuccessfulPersistence_ReturnsFalse() {
        
        // Arrange        
        ITeamSkillDAO teamSkillDAOImpl = new TeamSkillDAOImpl(mockedEntityManager);

        TeamSkill teamSkill = new TeamSkill();

        teamSkill.setSkill("Skill1");
        teamSkill.setTeamId("Team1");

        when(mockedEntityManager.getTransaction()).thenReturn(mockedEntityTransaction);
        doThrow(new Exception()).when(mockedEntityTransaction).begin();

        // Act
        boolean result = teamSkillDAOImpl.save(teamSkill);       
        
        // Assert
        assertFalse(result);
    }

}