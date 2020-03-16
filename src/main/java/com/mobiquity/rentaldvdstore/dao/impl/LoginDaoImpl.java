package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao {
    @Autowired
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
