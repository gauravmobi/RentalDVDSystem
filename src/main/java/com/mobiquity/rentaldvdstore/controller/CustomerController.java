package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.CustomerService;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.LoginService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    CustomerService customerService;


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
    public String customerRegistration(@RequestBody Customer customer){
        System.out.println(customer);
        return registrationService.userRegistration(customer);
    }

    @DeleteMapping("delete/{customerId}")
    @ResponseBody
    public String deleteCustomer(@PathVariable Long customerId ){
        return customerService.deleteCustomerService(customerId);
    }



}
