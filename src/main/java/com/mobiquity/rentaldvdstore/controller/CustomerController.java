package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.*;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.LoginService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {
    @Autowired
    ListingService listingService;
    @Autowired
    LoginService loginService;

    @Autowired(required = true)
    RegistrationService registrationService;

    @GetMapping("login")
    public String login(@PathVariable String email, @PathVariable String pass){
        return loginService.testLoginCredentials("AVINASH@GMAIL","AVINASH");
    }

    @GetMapping("customers")
    public List<Customer> getAllCustomers(){
        return listingService.getAllCustomers();
    }

    @GetMapping("rental")
    public  List<Rental> getDvdRentedCustomerList(){
        return listingService.getDvdRentedCustomersList();
    }

    @GetMapping("active")
    public List<Customer> getAllActiveCustomers(){
        return  listingService.getListOfAllActiveCustomers();
    }

    @PostMapping("register")
    public String registerCustomer(Customer customer) {
        System.out.println(customer);
        return registrationService.userRegistration(customer);
    }


}
