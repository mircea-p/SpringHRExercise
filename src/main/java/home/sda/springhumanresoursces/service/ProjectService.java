package home.sda.springhumanresoursces.service;

import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.model.Project;
import home.sda.springhumanresoursces.repository.EmployeeRepository;
import home.sda.springhumanresoursces.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveNewProject(Project project){
        log.info("Am salvat un proiect nou!");
        projectRepository.save(project);
    }

    public Set<Project> findByDepartmentName(String departmentName) {
        List<Employee> employeeList = employeeRepository.findAllByDepartment_Name(departmentName);
      Set<Project> projectSet = new HashSet<>();
//         employeeList.stream().map(i -> i.getProjectSet()).collect(Collectors.toSet());
        for(Employee employee: employeeList){
            projectSet.addAll(employee.getProjectSet());
        }
        return projectSet;
    }
}
