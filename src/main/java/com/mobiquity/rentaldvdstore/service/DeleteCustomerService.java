package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Service;

@Service
public interface DeleteCustomerService {
    public String deleteCustomerService( Long customerId);
}
