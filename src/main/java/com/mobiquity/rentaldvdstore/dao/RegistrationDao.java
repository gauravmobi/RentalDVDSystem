package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;

public interface RegistrationDao {
    String userRegistration(Customer customer);

    String testRegisteredEmailId(String email);

    Boolean validatePasswordPattern(String password);

    Boolean validateEmailPattern(String password);

    Boolean validateMobileNo(String mobile_no);

}
