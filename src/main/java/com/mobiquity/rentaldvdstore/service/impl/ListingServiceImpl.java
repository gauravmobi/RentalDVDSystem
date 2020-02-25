package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.ListingService;

import java.util.List;

public class ListingServiceImpl implements ListingService {

    private ListingDao listingDao;

    public void setListingDao(ListingDao listingDao) {
        this.listingDao = listingDao;
    }

    @Override
    public List<Dvd> getAllFilms() {
        if(!listingDao.getAllFilms().isEmpty())
            return listingDao.getAllFilms();
        else
            throw new IllegalArgumentException("Result Not Found");
    }
}
