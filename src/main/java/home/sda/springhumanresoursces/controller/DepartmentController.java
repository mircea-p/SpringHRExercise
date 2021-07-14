package home.sda.springhumanresoursces.controller;

import home.sda.springhumanresoursces.model.Department;
import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.repository.DepartmentRepository;
import home.sda.springhumanresoursces.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/hr/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/get")
    public ResponseEntity<String> findAllDepartments(@RequestBody Department department) {

        Iterable<Department> departmentIterable = departmentService.getAllDepartments();

        return new ResponseEntity<String>("All Departments: " + departmentIterable.toString(), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<String> createNewDepartment(@RequestBody Department department) {
        log.info("Vreau sa salvez!");
        departmentService.saveUpdateDepartment(department);
        return new ResponseEntity<>("Am creat un Employee nou: " + department.toString(), HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department) {
        log.info("Vreau sa fac update!");
        departmentService.saveUpdateDepartment(department);
        return new ResponseEntity<>("Am facut update!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> updateEmployee(@RequestParam(value = "id") Integer departmentid) {
        log.info("Vreau sa Sterg!");
        departmentService.deleteDepartment(departmentid);
        return new ResponseEntity<>("Am sters Employee-ul cu id-ul: " + departmentid, HttpStatus.ACCEPTED);
    }



}
