package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public String validateUser(String email, String password) {
            try{
                String select = "SELECT c.password FROM Customer c WHERE c.email=:email and c.password=:password";
                Query query = entityManager.createQuery(select);
                query.setParameter("email", email);
                query.setParameter("password", password);
                return query.getSingleResult().toString();
            }catch (javax.persistence.NoResultException e){
                return "invalid email or password. failed to login ";
            }

    }
}
