package com.my.portafolio.controller;

import com.my.portafolio.model.Skill;
import com.my.portafolio.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    private final SkillService skillService;

    @Autowired
    public SkillController (SkillService skillService) {
        super();
        this.skillService = skillService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skill>> fetchAllSkills() {
        List<Skill> skills = this.skillService.findAll();

        return skills != null ?
                ResponseEntity.ok(skills) :
                ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PostMapping("/add")
    public ResponseEntity<Skill> saveSkill (@RequestBody Skill skillReq) {
        Skill skill = this.skillService.save(skillReq);
        return skill != null ?
                ResponseEntity.ok(skill) :
                ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
