package com.my.portafolio.service;

import com.my.portafolio.model.Project;
import com.my.portafolio.model.Skill;
import com.my.portafolio.repository.ProjectRepository;
import com.my.portafolio.repository.ProjectSkillRepository;
import com.my.portafolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectSkillService {
    private final ProjectSkillRepository projectSkillRepository;
    private final ProjectRepository projectRepository;

    private final SkillRepository skillRepository;

    @Autowired
    public ProjectSkillService (ProjectSkillRepository projectSkillRepository, ProjectRepository projectRepository, SkillRepository skillRepository) {
        super();
        this.projectSkillRepository = projectSkillRepository;
        this.projectRepository = projectRepository;
        this.skillRepository = skillRepository;
    }

    public List<Skill> findSkillByProject (int id) {
        Optional<Project> project = this.projectRepository.findById(id);
        if (project.isPresent()) {
            List<Skill> skills = this.projectSkillRepository.findSkillByProject(project.get());
            return skills;
        }
        return null;
    }

    public List<Project> findProjectsBySkill(int id) {
        Optional<Skill> skill = this.skillRepository.findById(id);
        if (skill.isPresent()) {
            List<Project> projects = this.projectSkillRepository.findProjectBySkill(skill.get());
            return projects;
        }
        return null;
    }
}
