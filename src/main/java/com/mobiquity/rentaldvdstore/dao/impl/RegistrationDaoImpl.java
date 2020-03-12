package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RegistrationDaoImpl implements RegistrationDao {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public String userRegistration(Customer customer) {
        try {
            System.out.println(customer);
            entityManager.persist(customer);
            return "Customer Registered Successfully";
        }
        catch (Exception e)
        {
           throw new RuntimeException();
        }
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
