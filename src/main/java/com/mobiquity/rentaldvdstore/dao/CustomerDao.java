package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao {
    public String deleteCustomer(Long customerId);
}
