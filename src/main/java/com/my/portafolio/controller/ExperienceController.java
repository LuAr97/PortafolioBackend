package com.my.portafolio.controller;

import com.my.portafolio.model.Experience;
import com.my.portafolio.repository.ExperienceRepository;
import com.my.portafolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/experience")
public class ExperienceController {
    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController (ExperienceService experienceService) {
        super();
        this.experienceService = experienceService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Experience>> retrieveAllExperience () {
        List<Experience> experiences = this.experienceService.findAll();
        return  experiences != null ?
                ResponseEntity.ok(experiences) :
                ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
