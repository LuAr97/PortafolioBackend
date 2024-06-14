package com.my.portafolio.model;

import jakarta.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;


    public Skill() {
    }

    public Skill(String name, String img) {

        this.name = name;
        this.img = img;

    }

    public Skill(String name) {

        this.name = name;
        this.img = "/skills/default.png";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
