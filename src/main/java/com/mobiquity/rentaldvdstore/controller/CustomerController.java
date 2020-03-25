package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.DeleteCustomerService;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.LoginService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> listOfAllCustomers = listingService.getAllCustomers();
        if (listOfAllCustomers.size()==0)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(listOfAllCustomers);

    }

    @GetMapping("active")
    public  ResponseEntity<List<Customer>>getAllActiveCustomers() {
        List<Customer> listOfAllActiveCustomers =listingService.getListOfAllActiveCustomers();
        if (listOfAllActiveCustomers.size()==0)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(listOfAllActiveCustomers);
    }

    @GetMapping("login")
    public String customerLogin(){
        return loginService.testLoginCredentials("gaurav","gaurav");
    }



    @PostMapping("registration")
    public ResponseEntity<String> customerRegistration(@RequestBody Customer customer){
        System.out.println(customer);
        String str= registrationService.userRegistration(customer);
        if (str == null)
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok("okay");
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
//                "/{id}").buildAndExpand(customer.getCustomerId()).toUri();

        //return ResponseEntity.created(location).build();

    }

    @DeleteMapping("delete/{customerId}")
    @ResponseBody
    public String deleteCustomer(@PathVariable Long customerId ){
        return deleteCustomerService.deleteCustomerService(customerId);

    }



}
