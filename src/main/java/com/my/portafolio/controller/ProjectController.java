package com.my.portafolio.controller;

import com.my.portafolio.model.Project;
import com.my.portafolio.model.Skill;
import com.my.portafolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController (ProjectService projectService) {
        super();
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public String add(@RequestBody Project project){
        projectService.saveProject(project);
        return "New Student is added";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> fetchAllProjects() {
        List<Project> projects = this.projectService.findAll();

        return projects != null ?
                ResponseEntity.ok(projects) :
                ResponseEntity.status(HttpStatus.CONFLICT).build();
    }



}
