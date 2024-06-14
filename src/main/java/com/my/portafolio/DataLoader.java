package com.my.portafolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.portafolio.model.*;
import com.my.portafolio.repository.*;
import com.my.portafolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DataLoader implements CommandLineRunner {

    private final SkillRepository skillRepository;
    private final ProjectRepository projectRepository;
    private final ProjectSkillRepository projectSkillRepository;

    private final ExperienceRepository experienceRepository;

    private final TaskRepository taskRepository;
    @Override
    @Transactional
    public void run(String... args) throws Exception {
        loadData();
        loadExperience();
    }

    @Autowired
    public DataLoader(TaskRepository taskRepository, ExperienceRepository experienceRepository, SkillRepository skillRepository, ProjectRepository projectRepository, ProjectSkillRepository projectSkillRepository) {
        super();
        this.skillRepository = skillRepository;
        this.projectRepository = projectRepository;
        this.projectSkillRepository = projectSkillRepository;
        this.experienceRepository = experienceRepository;
        this.taskRepository = taskRepository;
    }

    public void loadData () {
        Skill java = skillRepository.save(
                new Skill("Java", "/skills/java.png")
        );
        Skill python = skillRepository.save(
                new Skill("Python", "/skills/python.png")
        );
        Skill selenium = skillRepository.save(
                new Skill("Selenium", "/skills/selenium.png")
        );
        Skill cucumber = skillRepository.save(
                new Skill("Cucumber", "/skills/cucumber.png")
        );
        Skill react = skillRepository.save(
                new Skill("React", "/skills/react.png")
        );
        Skill mySQL = skillRepository.save(
                new Skill("MySQL", "/skills/mysql.png")
        );
        Skill sql = skillRepository.save(
                new Skill("SQL", "/skills/sql.png")
        );
        Skill javaScript = skillRepository.save(
                new Skill("JavaScript", "/skills/javascript.png")
        );
        Skill css = skillRepository.save(
                new Skill("CSS", "/skills/css.png")
        );

        Project automation = projectRepository.save(
                new Project("Automation", "https://github.com/LuAr97/Automation", "This project is an automated process of login into a website. and request a contact. More than you automized a process, with cucumber there is use of step definitiones which make each step of the automation more clear for a non tech person","/projects/selenium.mp4")
        );

        Project spa = projectRepository.save(
                new Project("SpaWebsite", "https://github.com/LuAr97/spawebsite", "This project is a website dedicated to spa enthusiasts, offering a seamless platform to explore and book a variety of spa treatments. Users can browse through a curated selection of services, ranging from massages to facials, and conveniently schedule their appointments online.","/projects/spa.mp4")
        );

        Project portafolio = projectRepository.save(
                new Project("Portafolio", "https://github.com/LuAr97/PortafolioFrontend", "This project is an essential part of my portfolio. This project represents my expertise in crafting interactive and user-friendly interfaces using React and TypeScript.","/projects/portafolio.mp4")
        );

        Project webscraping = projectRepository.save(
                new Project("Webscraping JOB SEEK", "https://github.com/LuAr97/Webscraping", "This project recolects information from a job seek website and display the top 5 latest job opportunities. ","/projects/webscraping.mp4")
        );

        projectSkillRepository.save(
                new ProjectSkill(spa, mySQL)
        );
        projectSkillRepository.save(
                new ProjectSkill(spa, react)
        );

        projectSkillRepository.save(
                new ProjectSkill(portafolio, react)
        );

        projectSkillRepository.save(
                new ProjectSkill(portafolio, java)
        );

        projectSkillRepository.save(
                new ProjectSkill(portafolio, mySQL)
        );

        projectSkillRepository.save(
                new ProjectSkill(automation, cucumber)
        );

        projectSkillRepository.save(
                new ProjectSkill(automation, selenium)
        );

        projectSkillRepository.save(
                new ProjectSkill(automation, java)
        );

        projectSkillRepository.save(
                new ProjectSkill(webscraping, python)
        );
    }

    public void loadExperience () {
        Experience exp4 = new Experience("IAG", "Software Developer","Sep 2022", "Feb 2024");
        experienceRepository.save(exp4);
        taskRepository.save( new Task(exp4, "Designed and developed software solutions through ORBIT and oracle databases."));
        taskRepository.save( new Task(exp4, "Integrated react components into orbit product using micro-front ends."));
        taskRepository.save( new Task(exp4, "Built and deployed changes to environments using bamboo."));
        taskRepository.save( new Task(exp4, "Fixed and resolved production and lower environment bugs and problems."));

        Experience exp3 = new Experience("Servir S.A.", "Web Developer","Jul 2018", "Dec 2018");
        experienceRepository.save(exp3);
        taskRepository.save( new Task(exp3, "Developed new software to digitize timesheet and pay check process at University of Itsmo (UNIS)."));
        taskRepository.save( new Task(exp3, "Self-learned the new technology using tutorials in one month."));
        taskRepository.save( new Task(exp3, "Developed and designs the database for the software, in order to optimize the software and the client changes."));

        Experience exp2 = new Experience("Basis Consultores", "Analyst Programmer","Sep 2017", "Jan 2018");
        experienceRepository.save(exp2);
        taskRepository.save( new Task(exp2, "Provided Software and Technical support to loan companies in Guatemala and Belize including DHL in Guatemala, Costa Rica and Panama."));
        taskRepository.save( new Task(exp2, "Reduced 80% support calls by fixing the root problem in the software."));
        taskRepository.save( new Task(exp2, "Found solutions for improvements in loan companies’ software."));
        taskRepository.save( new Task(exp2, "Set up a new version of the software for a new client, based on the information obtained through weekly meetings with the client."));

        Experience exp1 = new Experience("Universidad del Valle de Guatemala", "Class Assistant Operative Systems & Data Structures","Jan 2018", "Dec 2018");
        experienceRepository.save(exp1);
        taskRepository.save( new Task(exp1, "Assisted students with queries related to projects and assignments."));
        taskRepository.save( new Task(exp1, "Set up and gave lectures to the students on Linux and Data Structures."));
        taskRepository.save( new Task(exp1, "Explained to students the new ways of using the programming language to achieve the practical class goals."));
        taskRepository.save( new Task(exp1, "Followed the progress of the students during the development of the LFS (Linux From Scratch)."));

    }
}
