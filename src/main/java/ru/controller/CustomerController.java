package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dao.CustomerDao;
import ru.entity.Customer;
import ru.sevice.CustomerService;
import ru.sevice.CustomerServiceInt;

import javax.jws.WebParam;
import java.util.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerServiceInt customerService;

    @Autowired
    public CustomerController(CustomerServiceInt customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String getCustomerList(Model model) {
        List<Customer> customers = customerService.getAll();

        model.addAttribute("customers", customers);

        return "customer-list";
    }

    @GetMapping("/create")
    public String getForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "form";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.save(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam(name = "customerId") int id, Model model) {

        Customer customer = customerService.get(id);

        model.addAttribute("customer", customer);

        return "form";

    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "customerId") int id) {

        customerService.delete(id);

        return "redirect:/customer/list";

    }



}
