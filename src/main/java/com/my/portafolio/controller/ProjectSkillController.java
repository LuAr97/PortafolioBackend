package com.my.portafolio.controller;

import com.my.portafolio.model.Project;
import com.my.portafolio.model.Skill;
import com.my.portafolio.service.ProjectSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/projectskill")
public class ProjectSkillController {
    private final ProjectSkillService projectSkillService;

    @Autowired
    public ProjectSkillController (ProjectSkillService projectSkillService) {
        super();
        this.projectSkillService = projectSkillService;
    }

    @GetMapping("/skills/{projectId}")
    public ResponseEntity<List<Skill>> findSkillByProject(@PathVariable int projectId) {
        List<Skill> skills = this.projectSkillService.findSkillByProject(projectId);
        return skills != null ?
                ResponseEntity.ok(skills) :
                ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping("/projects/{skillId}")
    public ResponseEntity<List<Project>> findProjectBySkill(@PathVariable int skillId) {
        List<Project> projects = this.projectSkillService.findProjectsBySkill(skillId);
        return projects != null ?
                ResponseEntity.ok(projects) :
                ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
