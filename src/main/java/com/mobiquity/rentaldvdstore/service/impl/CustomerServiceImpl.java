package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.CustomerDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;
    public void setCustomerDao(CustomerDao customerDao){this.customerDao=customerDao;}
    @Override
    public String deleteCustomerService( Long customerId){
        if (customerId != null) {
                    return customerDao.deleteCustomer(customerId);
        }else {
            throw new IllegalArgumentException("customer not found");
            }
    }
}
