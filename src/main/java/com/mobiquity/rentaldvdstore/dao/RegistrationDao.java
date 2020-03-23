package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationDao {
    String userRegistration(Customer customer);

    String testRegisteredEmailId(String email);

    Boolean validatePasswordPattern(String password);

    Boolean validateEmailPattern(String password);
}
