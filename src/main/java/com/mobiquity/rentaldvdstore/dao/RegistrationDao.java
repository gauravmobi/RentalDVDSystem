package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDao {
    String userRegistration(Customer customer);

    String testRegisteredEmailId(String email);

    String registerCustomer(Customer customer);

    Boolean validatePasswordPattern(String password);

    Boolean validateEmailPattern(String password);

    Boolean validateMobileNo(String mobile_no);

}
