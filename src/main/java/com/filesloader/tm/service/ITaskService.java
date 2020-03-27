package com.filesloader.tm.service;

import java.util.List;

import com.filesloader.tm.entity.Task;

public interface ITaskService {

    public List<Task> findAll();

    public Task findById(int theId);

    public void save(Task theTask);

    public void deleteById(int theId);

}