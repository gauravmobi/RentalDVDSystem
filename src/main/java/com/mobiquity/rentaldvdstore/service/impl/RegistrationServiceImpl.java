package com.mobiquity.rentaldvdstore.service.impl;


import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService
{
    private RegistrationDao registrationDao;

    public void setRegistrationDao(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    @Override
    public String userRegistration(Customer customer) {
        try {
            if (null != registrationDao.userRegistration(customer)) {
                return "Registration Success";
            } else {
                return "Registration Failed";
            }
        } catch (Exception e) {
            return "Registration Failed";
        }
    }
}
