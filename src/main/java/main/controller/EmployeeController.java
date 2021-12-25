package main.controller;

import main.domain.Employee;
import main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {
    private static final String EMPLOYEE_PARAM = "employee";
    public static final String ID_PARAM = "id";

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    @RequestMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);

        return "show-all-employees";
    }

    @GetMapping("/addEmployee")
    public String showEmployeeInfo(Model model) {
        model.addAttribute(EMPLOYEE_PARAM, new Employee());
        return "employee-editor";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute(EMPLOYEE_PARAM) Employee employee) {
        service.save(employee);

        return "redirect:/";
    }

    @GetMapping("/updateEmployee")
    public String updateEmployee(@RequestParam(name = ID_PARAM) int id, Model model) {
        Employee employee = service.get(id);
        model.addAttribute(EMPLOYEE_PARAM, employee);

        return "employee-editor";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(name = ID_PARAM) int id) {
        service.delete(id);
        return "redirect:/";
    }
}
