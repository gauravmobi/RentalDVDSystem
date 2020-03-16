package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public String userRegistration(Customer customer) {
            entityManager.persist(customer);
            return "Customer Registered Successfully";
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
