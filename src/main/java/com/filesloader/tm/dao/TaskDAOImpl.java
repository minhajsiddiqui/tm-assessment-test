package com.filesloader.tm.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.filesloader.tm.entity.Task;

import org.apache.log4j.Logger;

public class TaskDAOImpl implements ITaskDAO {

    final static Logger logger = Logger.getLogger(TaskDAOImpl.class);

    private EntityManager _entityManager;

    public TaskDAOImpl(EntityManager entityManager) {
        _entityManager = entityManager;
    }

    @Override
    public List<Task> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Task findById(int Id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean save(Task task) {
        EntityTransaction et = null;

        try {
            et = _entityManager.getTransaction();
            et.begin();

            _entityManager.persist(task);

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
