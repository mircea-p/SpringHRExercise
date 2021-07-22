package home.sda.springhumanresoursces.repository;

import home.sda.springhumanresoursces.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>{
}
