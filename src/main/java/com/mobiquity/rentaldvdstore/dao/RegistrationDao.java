package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;

public interface RegistrationDao {
    String userRegistration(Customer customer);

    String testRegisteredEmailId(String email);
}
