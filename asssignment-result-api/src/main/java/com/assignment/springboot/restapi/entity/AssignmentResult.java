package com.assignment.springboot.restapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="assignmentResult")
public class AssignmentResult {

	// define fields
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="assignment_result_id")
	private int assignmentResultId;
	
	@Column(name="task_id")
	private String taskId;
	
	@Column(name="skill")
	private String skill;
	
	public AssignmentResult() {
		
	}

	public AssignmentResult(String taskId, String skill) {
		this.taskId = taskId;
		this.skill = skill;
	}

	// define getter/setter
	
	public int getAssignmentResultId() {
		return assignmentResultId;
	}

	public void setAssignmentResultId(int id) {
		this.assignmentResultId = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}		
}











