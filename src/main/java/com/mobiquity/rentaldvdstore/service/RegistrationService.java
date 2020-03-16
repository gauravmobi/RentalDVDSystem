package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    String userRegistration(Customer customer);

    String registerCustomer(Customer customer);

    String testRegisteredEmailId(String email);
}
