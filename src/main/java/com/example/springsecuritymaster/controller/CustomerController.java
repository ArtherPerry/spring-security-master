package com.example.springsecuritymaster.controller;


import com.example.springsecuritymaster.dao.CustomerDao;
import com.example.springsecuritymaster.ds.Customer;
import com.example.springsecuritymaster.security.annotation.customers.IsCustomersCreate;
import com.example.springsecuritymaster.security.annotation.customers.IsCustomersDelete;
import com.example.springsecuritymaster.security.annotation.customers.IsCustomersRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.processing.Generated;
import javax.validation.Valid;


@Controller
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @IsCustomersRead
    @GetMapping("/customers")
    public ModelAndView findAllCustomer() {
        return new ModelAndView(
                "customers",
                "customers",
                customerDao.findAll()
        );
    }

    @IsCustomersCreate
    @GetMapping("/create-customer")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @IsCustomersCreate
    @PostMapping("/create-customer")
    public String processCustomer(@Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }
        customerDao.save(customer);
        return "redirect:/customers";
    }

    @IsCustomersDelete
    @GetMapping("/customers/delete")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerDao.deleteById(id);
        return "redirect:/customers";
    }
}
