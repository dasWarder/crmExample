package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dao.CustomerDao;
import ru.entity.Customer;
import ru.sevice.CustomerService;
import ru.sevice.CustomerServiceInt;
import ru.util.exception.CustomerNotFound;

import javax.jws.WebParam;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerServiceInt customerService;

    @Autowired
    public CustomerController(CustomerServiceInt customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomerList(Model model) {
        List<Customer> customers = customerService.getAll();

        model.addAttribute("customers", customers);

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {

        Customer customer = customerService.get(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {

        customer.setId(0);

        customerService.save(customer);

        return customer;
    }

    @PutMapping("/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {


        customerService.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") int id) {

        customerService.delete(id);

        return new ResponseEntity<>("The customer with id " + id + " was delete",
                HttpStatus.OK);
    }


}
