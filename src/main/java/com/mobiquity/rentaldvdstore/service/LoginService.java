package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.List;

@Service
public interface LoginService {
    public String validateUser(String email, String password);
}
