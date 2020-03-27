package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.SearchDvdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class SearchController {
    @Autowired
    ListingService listingService;

    @GetMapping("customers")
    public List<Customer> findCustomersByName(@RequestParam("name") String name) {
        if (name.isEmpty()) {
            return listingService.getAllCustomers();
        } else {
            return listingService.getCustomersByName(name);
        }
    }
}
