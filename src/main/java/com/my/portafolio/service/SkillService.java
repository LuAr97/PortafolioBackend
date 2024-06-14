package com.my.portafolio.service;

import com.my.portafolio.model.Skill;
import com.my.portafolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    @Autowired
    public SkillService (SkillRepository skillRepository) {
        super();
        this.skillRepository = skillRepository;
    }

    public List<Skill> findAll() {
        return this.skillRepository.findAll();
    }

    public Skill save(Skill skillReq) {
       return this.skillRepository.save(skillReq);
    }
}
