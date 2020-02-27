package com.mobiquity.rentaldvdstore.Controller;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    ListingService listingService;

    @GetMapping("customer")
    public List<Customer> getAllCustomer(){
        return listingService.getAllCustomers();
    }
}
