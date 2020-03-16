package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    public String getPasswordByUsername(String username);
    public Customer validateCustomer(String email, String password);
}
