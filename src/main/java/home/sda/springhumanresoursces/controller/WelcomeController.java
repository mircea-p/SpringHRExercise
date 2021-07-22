package home.sda.springhumanresoursces.controller;

import home.sda.springhumanresoursces.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WelcomeController {
    public static final String HELLO_MESSAGE = "myCustomHelloMessage";
    public static final String HELLO_MESSAGE_VALUE = "Hello! Welcome to the Spring HR Application!";
    public static final String ACTION_ONE = "Get all employees!";

    @GetMapping(value = "/welcome")
    public String welcome(ModelMap modelMap) {
        modelMap.addAttribute(HELLO_MESSAGE, HELLO_MESSAGE_VALUE);
        modelMap.addAttribute("actionOne", "Get all employees!!");
        modelMap.addAttribute("actionTwo", "Add new Employee.");
        modelMap.addAttribute("actionThree", "Delete an Employee.");
        return "welcome";
    }
    @GetMapping(value = "/addNewEmployee")
    public String addNewEmployee(ModelMap modelMap) {
        modelMap.addAttribute("employee", new Employee());
        return "add-employee";
    }
    @PostMapping(value = "/deleteEmployees")
    public String deleteEmployees(ModelMap modelMap){
        return "delete-employees";
    }

}
