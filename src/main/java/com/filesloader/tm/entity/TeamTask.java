package com.filesloader.tm.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assignmentResult")
public class TeamTask implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int Id;

    @Column(name = "team_id", nullable = false)
    private String teamId;

    @Column(name = "task_id", nullable = false)
    private String taskId;

    public int getId() {
    return Id;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}