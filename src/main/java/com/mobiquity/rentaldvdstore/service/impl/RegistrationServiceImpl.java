package com.mobiquity.rentaldvdstore.service.impl;


import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.helper.RegistrationValidator;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.RegistrationService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationDao registrationDao;

    public void setRegistrationDao(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    @Override
    public String userRegistration(Customer customer) {
        if (customer != null) {
            if (RegistrationValidator.validateEmailPattern(customer.getEmail())
                    && RegistrationValidator.validatePasswordPattern(customer.getPassword())
                    && RegistrationValidator.validateMobileNoPattern(customer.getMobile_no())) {
                try {
                    if (null != registrationDao.userRegistration(customer)) {
                        return "Registration Success";
                    } else {
                        return "Registration Failed";
                    }
                } catch (Exception e) {
                    return "Registration Failed";
                }
            } else {
                throw new IllegalArgumentException("Invalid Email Or Password Or MobileNo");
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String testRegisteredEmailId(String email) {
        if (email.equals(registrationDao.testRegisteredEmailId(email))) {
            return "Email Id already Registered";
        } else {
            return "Registration Success";
        }
    }
}
