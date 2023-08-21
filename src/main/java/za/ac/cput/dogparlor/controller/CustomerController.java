package za.ac.cput.dogparlor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.dogparlor.domain.Customer;
import za.ac.cput.dogparlor.dto.AuthRequest;
import za.ac.cput.dogparlor.factory.CustomerFactory;
import za.ac.cput.dogparlor.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/signup")
    public Customer signup(@RequestBody Customer customer) {
        Customer createdCustomer = CustomerFactory.createCustomer(customer.getFirstName(),
                customer.getLastName(), customer.getEmail(), customer.getPhone(),
                customer.getPassword(), customer.getAddresses());

        return customerService.create(createdCustomer);
    }

    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id) {
        return customerService.read(id);
    }

    @PostMapping("/login")
    public Customer login(@RequestBody AuthRequest authRequest) {
        System.out.println(customerService.login(authRequest.getEmail(), authRequest.getPassword()));
        return customerService.login(authRequest.getEmail(), authRequest.getPassword());
    }

}
