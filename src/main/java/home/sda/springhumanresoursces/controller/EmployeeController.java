package home.sda.springhumanresoursces.controller;

import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/hr/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get")
    public ResponseEntity<String> getAllEmployees() {
        Iterable<Employee> employeeIterable = employeeService.getAllEmpoyees();
        return new ResponseEntity<String>("Merge!" + employeeIterable.toString(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        log.info("Vreau sa salvez!");
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Am creat un Employee nou: " + employee.toString(), HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        log.info("Vreau sa fac update!");
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>("Am facut update!", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    @Transactional
    public ResponseEntity<String> deleteEmployee(@RequestParam(value = "id", required = false) Integer employeeid) {
        log.info("Vreau sa Sterg!");
        Integer sters;
        if(employeeid == null){
            throw new IllegalArgumentException("Id-ul Employee-ului lipseste, nu putem sterge fara el");
        }else {
            sters = employeeService.deleteEmployeeById(employeeid);
        }

        if(sters == 1)
            return new ResponseEntity<>("Am sters Employee-ul cu id-ul: " + employeeid, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>("Nu s-a sters, id Employee inexistent! Id: " + employeeid, HttpStatus.BAD_REQUEST);


    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal arguments...bla bla: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
