package com.my.portafolio.repository;

import com.my.portafolio.model.Project;
import com.my.portafolio.model.ProjectSkill;
import com.my.portafolio.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProjectSkillRepository extends JpaRepository<ProjectSkill, Integer> {

    @Query(value = "SELECT project FROM ProjectSkill WHERE skill = ?1", nativeQuery = false)
    List<Project> findProjectBySkill(Skill skill);

    @Query(value = "SELECT skill FROM ProjectSkill WHERE project = ?1", nativeQuery = false)
    List<Skill> findSkillByProject(Project project);
}
