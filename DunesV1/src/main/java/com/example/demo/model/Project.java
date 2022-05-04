package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="projects")
public class Project {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="projectName")
	private String projectName;
	
	//@Column(name="projectManager")
	@ManyToOne(cascade = CascadeType.ALL)
	private User projectManager;
	
	@Column(name="projectBudget")
	private float projectBudget;

	public User getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public float getProjectBudget() {
		return projectBudget;
	}

	public void setProjectBudget(float projectBudget) {
		this.projectBudget = projectBudget;
	}
	
}
