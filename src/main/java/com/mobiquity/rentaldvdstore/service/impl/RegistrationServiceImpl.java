package com.mobiquity.rentaldvdstore.service.impl;


import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.helper.RegistrationValidator;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.repository.CustomerRepository;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationDao registrationDao;

    @Autowired
    CustomerRepository customerRepository;

    public void setRegistrationDao(RegistrationDao registrationDao) {
        this.registrationDao = registrationDao;
    }

    @Override
    public String userRegistration(Customer customer) {
        if (customer != null) {
            if (RegistrationValidator.validateEmailPattern(customer.getEmail())
                    && RegistrationValidator.validatePasswordPattern(customer.getPassword())
                    && RegistrationValidator.validateMobileNoPattern(customer.getMobileNo())) {
                try {
                    if (null != customerRepository.save(customer)) {
                        return "Registration Success";
                    } else {
                        return "Registration Failed";
                    }
                } catch (Exception e) {
                    return "Registration Failed";
                }
            } else {
                throw new IllegalArgumentException("Invalid Email Or Password Or MobileNo");
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String registerCustomer(Customer customer) {

        return registrationDao.userRegistration(customer);
    }

    @Override
    public String testRegisteredEmailId(String email) {
        if (email.equals(registrationDao.testRegisteredEmailId(email))) {
            return "Email Id already Registered";
        } else {
            return "Registration Success";
        }
    }
}
