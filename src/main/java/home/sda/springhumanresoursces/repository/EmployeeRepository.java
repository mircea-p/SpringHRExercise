package home.sda.springhumanresoursces.repository;

import home.sda.springhumanresoursces.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    public Integer deleteEmployeeById(Integer id);
}
