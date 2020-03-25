package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteCustomerDao {
    public String deleteCustomer(Long customerId);
}
