package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Customer;

public interface RegistrationService {

    String userRegistration(Customer customer);

    String registerCustomer(Customer customer);

    String testRegisteredEmailId(String email);
}
