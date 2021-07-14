package home.sda.springhumanresoursces.controller;

import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> updateEmployee(@RequestParam(value = "id") Integer employeeid) {
        log.info("Vreau sa Sterg!");
        employeeService.deleteEmployee(employeeid);
        return new ResponseEntity<>("Am sters Employee-ul cu id-ul: " + employeeid, HttpStatus.ACCEPTED);
    }

}
