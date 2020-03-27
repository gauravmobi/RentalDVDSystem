package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.pojo.Rental;
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
        Query query = entityManager.createQuery("FROM Dvd", Dvd.class);
        return query.getResultList();
    }

    @Override
    public List<Rental> getDvdRentedCustomersList() {
        return null;
    }

    @Override
    public List<Customer> getAllCustomers() {
        Query query = entityManager.createQuery("FROM Customer", Customer.class);
        return query.getResultList();
    }

    @Override
    public List<Customer> getListOfAllActiveCustomers() {
        Query query = entityManager.createQuery("FROM Customer where active = true",Customer.class);
        return query.getResultList();
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        Query query = entityManager.createQuery("SELECT c " +
                "FROM Customer c where c.firstName=:firstName or c.lastName=:lastName",Customer.class);
        query.setParameter("firstName",name);
        query.setParameter("lastName",name);
        return query.getResultList();
    }
}
