package com.my.portafolio.model;

import jakarta.persistence.*;

@Entity
public class ProjectSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Skill skill;

    public ProjectSkill() {
    }

    public ProjectSkill(Project project, Skill skill) {
        this.project = project;
        this.skill = skill;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
