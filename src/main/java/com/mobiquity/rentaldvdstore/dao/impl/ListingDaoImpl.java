package com.mobiquity.rentaldvdstore.dao.impl;


import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class ListingDaoImpl implements ListingDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Dvd> getAllFilms() {
        Query query = entityManager.createQuery("FROM Dvd",Dvd.class);
        return query.getResultList();
    }

    @Override
    public List<Customer> getAllCustomers() {
        Query query = entityManager.createQuery("FROM Customer",Customer.class);
        return query.getResultList();
    }
}
