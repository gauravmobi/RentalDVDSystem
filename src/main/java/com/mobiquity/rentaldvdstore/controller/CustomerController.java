package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.LoginService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {
    @Autowired
    ListingService listingService;
    @Autowired
    LoginService loginService;
    @Autowired
    RegistrationService registrationService;

    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        return listingService.getAllCustomers();
    }

    @GetMapping("active")
    public List<Customer> getAllActiveCustomers() {
        return listingService.getListOfAllActiveCustomers();
    }

    @GetMapping("login")
    public String customerLogin(){
        return loginService.testLoginCredentials("gaurav","gaurav");
    }

    @PostMapping("registration")
    public String customerRegistration(Customer customer){
        return registrationService.userRegistration(customer);
    }
}
