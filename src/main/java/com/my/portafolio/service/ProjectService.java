package com.my.portafolio.service;

import com.my.portafolio.model.Project;
import com.my.portafolio.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService (ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
    }

    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> findAll() { return projectRepository.findAll(); }
}
