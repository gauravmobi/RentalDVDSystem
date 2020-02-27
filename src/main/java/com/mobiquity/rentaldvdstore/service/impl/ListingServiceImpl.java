package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Customer> getAllCustomers() {
        return listingDao.getAllCustomers();
    }
}
