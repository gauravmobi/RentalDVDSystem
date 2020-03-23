package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.CustomerDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    @Override
    public String deleteCustomer(Long customerId) {
        Customer customer = entityManager.find(Customer.class, customerId);
        if(customer!=null){
            entityManager.remove(customer);
            return "customer with id " +customerId +" deleted successfully";
        }else{
            return " record not found. failed to delete";
        }
    }
}
