package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public String validateUser(String email, String password) {
        if (email != null && password != null) {
            if (password.equals(loginDao.validateUser(email, password))) {
                return "login successful";
            }
            return "login failed";
            } else {
            throw new IllegalArgumentException("Email or password invalid");
        }
    }
}

