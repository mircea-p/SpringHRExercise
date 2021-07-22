package home.sda.springhumanresoursces.controller;

import home.sda.springhumanresoursces.model.Account;
import home.sda.springhumanresoursces.model.Department;
import home.sda.springhumanresoursces.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("hr/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/save")
    public ResponseEntity<String> createNewAccount(@RequestBody Account newAccount) {
        log.info("Vreau sa salvez!");
        accountService.saveAccount(newAccount);
        return new ResponseEntity<>("Am creat un Account nou: " + newAccount.toString(), HttpStatus.CREATED);

    }

}
