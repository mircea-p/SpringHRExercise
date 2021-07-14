package home.sda.springhumanresoursces.repository;

import home.sda.springhumanresoursces.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
