package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
    @Autowired
    EntityManager entityManager;

    @Override
    public String userRegistration(Customer customer) {
        try {
            entityManager.persist(customer);
            return "Registration Successfull";
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Override
    public String testRegisteredEmailId(String email) {
        return null;
    }

    @Override
    public String registerCustomer(Customer customer) {
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
