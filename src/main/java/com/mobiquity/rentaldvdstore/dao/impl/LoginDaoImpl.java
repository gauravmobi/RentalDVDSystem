package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
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
}
