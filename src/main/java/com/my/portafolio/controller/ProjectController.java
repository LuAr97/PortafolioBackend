package com.my.portafolio.controller;

import com.my.portafolio.model.Project;
import com.my.portafolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public String add(@RequestBody Project project){
        projectService.saveProject(project);
        return "New Student is added";
    }

}
