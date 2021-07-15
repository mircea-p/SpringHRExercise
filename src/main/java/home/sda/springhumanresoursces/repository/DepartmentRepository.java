package home.sda.springhumanresoursces.repository;

import home.sda.springhumanresoursces.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
     Department findDepartmentById(Integer id);
     Department findDepartmentByName(String name);

}
