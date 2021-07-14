package home.sda.springhumanresoursces.service;


import home.sda.springhumanresoursces.model.Department;
import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Iterable<Department> getAllDepartments() {

        return departmentRepository.findAll();

    }
    public void saveUpdateDepartment(Department department){
        departmentRepository.save(department);
        log.info("Sefule, alo, am salvat un Department nou!!!");
    }
    public void deleteDepartment(Integer id){
        departmentRepository.deleteById(id);
        log.info("Sefule, alo, am sters un Departament!");
    }
}
