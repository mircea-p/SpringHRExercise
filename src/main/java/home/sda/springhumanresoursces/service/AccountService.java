package home.sda.springhumanresoursces.service;

import home.sda.springhumanresoursces.model.Account;
import home.sda.springhumanresoursces.model.Employee;
import home.sda.springhumanresoursces.repository.AccountRepository;
import home.sda.springhumanresoursces.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public Account saveAccount(Account newAccount) {
       // Optional<Employee> employee= employeeRepository.findById(newAccount.getEmployee().getId());

        Account savedAccount;
        savedAccount = accountRepository.save(newAccount);
        return savedAccount;
    }
}
