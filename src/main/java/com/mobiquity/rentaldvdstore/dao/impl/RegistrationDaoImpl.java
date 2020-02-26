package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {

    @Override
    public String userRegistration(Customer customer) {
        return null;
    }

    @Override
    public String testRegisteredEmailId(String email) {
        return null;
    }

    @Override
    public Boolean validatePasswordPattern(String password) {
        return null;
    }

    @Override
    public Boolean validateEmailPattern(String password) {
        return null;
    }

    @Override
    public Boolean validateMobileNo(String mobile_no) {
        return null;
    }

}
