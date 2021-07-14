package home.sda.springhumanresoursces.service;

import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee>getAllEmpoyees(){
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeRepository.save(employee);
        log.info("Sefule, alo, am salvat un Employee nou!!!");
    }
    public void deleteEmployee(Integer id){
        employeeRepository.deleteById(id);
        log.info("Sefule, alo, am sters un Employee!");
    }
}
