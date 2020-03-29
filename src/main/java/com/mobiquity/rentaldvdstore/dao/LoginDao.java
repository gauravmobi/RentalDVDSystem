package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDao {
    public String validateUser(String email, String password);
}
