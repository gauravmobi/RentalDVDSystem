package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Dvd;

import java.util.List;

public interface ListingDao {
    List<Dvd> getAllFilms();
}
