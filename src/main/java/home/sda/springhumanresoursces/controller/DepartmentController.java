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

    @GetMapping("/getAll")
    public ResponseEntity<String> findAllDepartments() {

        Iterable<Department> departmentIterable = departmentService.getAllDepartments();

        return new ResponseEntity<String>("All Departments: " + departmentIterable.toString() + "\n", HttpStatus.OK);
    }

    @GetMapping("/getById")
    public ResponseEntity<String> findDepartmentsById(@RequestParam(value = "id", required = false) Integer departmentId) {
        Department departmentGasit;
        if(departmentId == null){
            throw new IllegalArgumentException("Id-ul Departament-ului lipseste, nu putem cauta fara el!");
        }else {
          departmentGasit = departmentService.getDepartmentById(departmentId);
        }
        if(departmentGasit != null)
            return new ResponseEntity<>("Am gasit: " + departmentGasit, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("Departamentul cu Id-ul: " + departmentId +" nu exista in baza de date!", HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/getByName")
    public ResponseEntity<String> findDepartmentsByName(@RequestParam(value = "name", required = false) String departmentName) {
        Department departmentGasit;
        if(departmentName == null || departmentName.isEmpty()){
            throw new IllegalArgumentException("Numele Departament-ului lipseste, nu putem cauta fara el!");
        }else {
            departmentGasit = departmentService.getDepartmentByName(departmentName);
        }
        if(departmentGasit != null)
            return new ResponseEntity<>("Am gasit: " + departmentGasit, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("Departamentul cu numele: " + departmentName +" nu exista in baza de date!", HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/save")
    public ResponseEntity<String> createNewDepartment(@RequestBody Department department) {
        log.info("Vreau sa salvez!");
        departmentService.saveUpdateDepartment(department);
        return new ResponseEntity<>("Am creat un Department nou: " + department.toString(), HttpStatus.CREATED);

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
        return new ResponseEntity<>("Am sters Department-ul cu id-ul: " + departmentid, HttpStatus.ACCEPTED);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal arguments...bla bla: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
