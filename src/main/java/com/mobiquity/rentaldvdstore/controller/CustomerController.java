package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.DeleteCustomerService;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.LoginService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    DeleteCustomerService deleteCustomerService;


    @GetMapping("customers")
    public List<Customer> getAllCustomers() {
        return listingService.getAllCustomers();
    }

    @GetMapping("active")
    public  List<Customer> getAllActiveCustomers() {
        return listingService.getListOfAllActiveCustomers();
    }

    @GetMapping("login")
    public String customerLogin(@RequestParam("email")  String email , @RequestParam("password")  String password){
        return loginService.validateUser(email,password);
    }

    @PostMapping("registration")
    public String customerRegistration(@RequestBody Customer customer){
        return  registrationService.userRegistration(customer);
    }

    @DeleteMapping("delete/{customerId}")
    @ResponseBody
    public String deleteCustomer(@PathVariable Long customerId ){
        return deleteCustomerService.deleteCustomerService(customerId);

    }
}
