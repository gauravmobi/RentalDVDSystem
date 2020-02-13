package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import com.mobiquity.rentaldvdstore.service.LoginService;

public class LoginServiceImpl implements LoginService
{
    private LoginDao loginDao;

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public String testLoginCredentials(String username, String password)
    {
        String passwordByUsername=loginDao.getPasswordByUsername(username);
        if (password.equals(passwordByUsername))
        {
            return "Login Successfully";
        }
        else {
            return "Invalid Username/Password";
        }
    }
}
