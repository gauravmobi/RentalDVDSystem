package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.DeleteCustomerDao;
import com.mobiquity.rentaldvdstore.service.DeleteCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerServiceImpl implements DeleteCustomerService {
    @Autowired
    DeleteCustomerDao deleteCustomerDao;
    public void setDeleteCustomerDao(DeleteCustomerDao deleteCustomerDao){this.deleteCustomerDao = deleteCustomerDao;}
    @Override
    public String deleteCustomerService( Long customerId){
        if (customerId != null) {
                    return deleteCustomerDao.deleteCustomer(customerId);
        }else {
            throw new IllegalArgumentException("customer not found");
            }
    }
}
