package home.sda.springhumanresoursces.controller;

import home.sda.springhumanresoursces.model.Account;
import home.sda.springhumanresoursces.model.Project;
import home.sda.springhumanresoursces.repository.ProjectRepository;
import home.sda.springhumanresoursces.service.AccountService;
import home.sda.springhumanresoursces.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Slf4j
    @RestController
    @RequestMapping("hr/project")
    public class ProjectController {

        @Autowired
        ProjectRepository projectRepository;

        @Autowired
    ProjectService projectService;

        @PostMapping("/save")
        public ResponseEntity<String> createNewProject(@RequestBody Project newProject) {
            log.info("Vreau sa salvez!");
            projectRepository.save(newProject);
            return new ResponseEntity<>("Am creat un Proiect nou: " + newProject.toString(), HttpStatus.CREATED);

        }
        @GetMapping("/findByDepartmentName")
        public ResponseEntity<String> findByDepartmentName(@RequestParam(value = "depName") String departmentName){
            Set<Project> projectSet = projectService.findByDepartmentName(departmentName);
            return new ResponseEntity<>("Iatale:" + projectSet.toString(), HttpStatus.FOUND);
        }

    }


