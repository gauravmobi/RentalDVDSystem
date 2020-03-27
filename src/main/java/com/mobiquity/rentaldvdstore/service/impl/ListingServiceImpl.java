package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.pojo.Rental;
import com.mobiquity.rentaldvdstore.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingDao listingDao;

    public void setListingDao(ListingDao listingDao) {
        this.listingDao = listingDao;
    }

    @Override
    public List<Dvd> getAllFilms() {
        return listingDao.getAllFilms();
    }

    @Override
    public List<Rental> getDvdRentedCustomersList() {
        return listingDao.getDvdRentedCustomersList();
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customerList = listingDao.getAllCustomers();
        return listingDao.getAllCustomers();
    }

    @Override
    public List<Customer> getListOfAllActiveCustomers() {
        List<Customer> customerslist = null;
        if (listingDao.getListOfAllActiveCustomers() != null) {
            if (!listingDao.getListOfAllActiveCustomers().isEmpty()) {
                customerslist = listingDao.getListOfAllActiveCustomers();
                for (Customer c : customerslist) {
                    if (!c.getActive()) {
                        customerslist.remove(c);
                    }
                }
            }
            return customerslist;
        } else
            throw new IllegalArgumentException("Customer Not Found");
    }

    @Override
    public List<Customer> getCustomersByName(String name) {
        if(listingDao.getCustomersByName(name) != null)
        {
            if(listingDao.getCustomersByName(name).isEmpty()) {
                throw new IllegalArgumentException("Customer Not Found");
            }
            else
            {
                return listingDao.getCustomersByName(name);
            }
        }
        else
        {
            return listingDao.getCustomersByName(name);
        }
    }
}
