package home.sda.springhumanresoursces.repository;

import home.sda.springhumanresoursces.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

}
