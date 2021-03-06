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

@RunWith(MockitoJUnitRunner.class)
public class TaskDAOImplTest {

    @Mock
    EntityManager mockedEntityManager;

    @Mock
    EntityTransaction mockedEntityTransaction;

    @Test
    public void save_withSuccessfulPersistence_ReturnsTrue() {

        // Arrange        
        ITaskDAO taskDAOImpl = new TaskDAOImpl(mockedEntityManager);

        Task task = new Task();

        task.setTaskId("Task1");
        task.setSkill("Skill1");

        when(mockedEntityManager.getTransaction()).thenReturn(mockedEntityTransaction);        

        // Act
        boolean result = taskDAOImpl.save(task);       
        
        // Assert
        assertTrue(result);
    }

    @Test
    public void save_withUnSuccessfulPersistence_ReturnsFalse() {
        
        // Arrange        
        ITaskDAO taskDAOImpl = new TaskDAOImpl(mockedEntityManager);

        Task task = new Task();

        task.setTaskId("Task1");
        task.setSkill("Skill1");

        when(mockedEntityManager.getTransaction()).thenReturn(mockedEntityTransaction);
        doThrow(new Exception()).when(mockedEntityTransaction).begin();

        // Act
        boolean result = taskDAOImpl.save(task);       
        
        // Assert
        assertFalse(result);
    }

}