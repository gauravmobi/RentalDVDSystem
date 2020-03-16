package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class LoginDaoImpl implements LoginDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public String getPasswordByUsername(String username) {
        return null;
    }

    @Override
    public Customer validateCustomer(String email, String password) {
        return null;
    }
}
