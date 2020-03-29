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
    public String customerLogin(@RequestParam("email")  String email , @RequestParam("password")  String password){
        return loginService.validateUser(email,password);
    }



    @PostMapping("registration")
    public ResponseEntity<String> customerRegistration(@RequestBody Customer customer){
        System.out.println(customer);
        String str= registrationService.userRegistration(customer);
        if (str == null)
            return new ResponseEntity<String>( "registration failed",HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<String>( "Customer Registered Successfully",HttpStatus.OK);
    }

    @DeleteMapping("delete/{customerId}")
    @ResponseBody
    public String deleteCustomer(@PathVariable Long customerId ){
        return deleteCustomerService.deleteCustomerService(customerId);

    }


}
