package com.my.portafolio.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int experience_id;

    @Column(name = "company")
    private String company;

    @Column(name = "position")
    private String position;

    @Column(name = "entry")
    private String entry;

    @Column(name = "end")
    private String end;

    @OneToMany(mappedBy = "experience")
    private List<Task> tasks;

    public Experience() {
    }

    public Experience(String company, String position, String entry, String end) {
        this.company = company;
        this.position = position;
        this.entry = entry;
        this.end = end;
        this.tasks = new ArrayList<>();
    }

    public int getId() {
        return experience_id;
    }

    public void setId(int id) {
        this.experience_id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Task task) {
        this.tasks.add(task);
    }
}
