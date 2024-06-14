package com.my.portafolio.service;

import com.my.portafolio.model.Experience;
import com.my.portafolio.model.Task;
import com.my.portafolio.repository.ExperienceRepository;
import com.my.portafolio.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository, TaskRepository taskRepository) {
        super();
        this.experienceRepository = experienceRepository;
        this.taskRepository = taskRepository;
    }

    public Experience save(Experience experience) {
        List<Task> tasks = experience.getTasks();
        if (experience.getTasks().size() > 0){
            for(Task task : tasks) {
                taskRepository.save(task);
            }
        }
        return experienceRepository.save(experience);
    }

    public List<Experience> findAll() {
        return this.experienceRepository.findAll();
    }
}
