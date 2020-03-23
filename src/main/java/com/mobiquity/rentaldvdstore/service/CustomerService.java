package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public String deleteCustomerService( Long customerId);
}
