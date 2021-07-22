package home.sda.springhumanresoursces.service;

import home.sda.springhumanresoursces.model.Account;
import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.model.Project;
import home.sda.springhumanresoursces.repository.AccountRepository;
import home.sda.springhumanresoursces.repository.EmployeeRepository;
import home.sda.springhumanresoursces.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ProjectRepository projectRepository;


    public Iterable<Employee>getAllEmpoyees(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        Account newAccount = new Account(Date.valueOf(LocalDate.now()));
        employee.setAccount(accountRepository.save(newAccount));
        Employee savedEmployee = employeeRepository.save(employee);
        log.info("Sefule, alo, am salvat un Employee nou!!!");
        return savedEmployee;
    }
    public void updateEmployee(Employee employee){
        employeeRepository.save(employee);
    }
    public Integer deleteEmployeeById(Integer id){
        log.info("Sefule, alo, am sters un Employee!");
       return employeeRepository.deleteEmployeeById(id);
    }
    public List<Employee> findEmployeesByDepatmentName(String departmentName){
        log.info("Acuma caut sefule!");
        return employeeRepository.findAllByDepartment_Name(departmentName);
    }
    public void assignProject(Integer employeeId, Integer projectId)
    {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Optional<Project> project = projectRepository.findById(projectId);
        log.info("ok i-am gasit pe cei doi!");
        if(employee.isPresent() && project.isPresent()){
            employee.get().getProjectSet().add(project.get());
            project.get().getEmployeeSet().add(employee.get());
            employeeRepository.save(employee.get());
            projectRepository.save(project.get());
            log.info("Gata, i-am legat!");
        }
    }
}
