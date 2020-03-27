package com.filesloader.tm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.filesloader.tm.entity.Task;
import com.filesloader.tm.entity.Team;

@RunWith(MockitoJUnitRunner.class)
public class TeamDAOImplTest {

    @Mock
    EntityManager mockedEntityManager;

    @Mock
    EntityTransaction mockedEntityTransaction;

    @Test
    public void save_withSuccessfulPersistence_ReturnsTrue() {

        // Arrange        
        ITeamDAO teamDAOImpl = new TeamDAOImpl(mockedEntityManager);

        Team team = new Team();

        team.setTeamId("Team1");

        when(mockedEntityManager.getTransaction()).thenReturn(mockedEntityTransaction);        

        // Act
        boolean result = teamDAOImpl.save(team);       
        
        // Assert
        assertTrue(result);
    }

    @Test
    public void save_withUnSuccessfulPersistence_ReturnsFalse() {
        
        // Arrange        
        ITeamDAO teamDAOImpl = new TeamDAOImpl(mockedEntityManager);

        Team team = new Team();

        team.setTeamId("Team1");

        when(mockedEntityManager.getTransaction()).thenReturn(mockedEntityTransaction);
        doThrow(new Exception()).when(mockedEntityTransaction).begin();

        // Act
        boolean result = teamDAOImpl.save(team);       
        
        // Assert
        assertFalse(result);
    }
}