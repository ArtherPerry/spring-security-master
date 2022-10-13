package com.example.springsecuritymaster.controller;

import com.example.springsecuritymaster.dao.EmployeeDao;
import com.example.springsecuritymaster.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public ModelAndView listEmployees() {
        return new ModelAndView(
                "employees",
                "employees",
                employeeDao.findAll());
    }

    @GetMapping("/create-employee")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/create-employee")
    public String saveEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        employeeDao.deleteById(id);
        return "redirect:/employees";
    }
}
