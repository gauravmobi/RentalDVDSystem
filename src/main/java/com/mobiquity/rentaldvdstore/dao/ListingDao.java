package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ListingDao {
    List<Dvd> getAllFilms();
    List<Customer> getAllCustomers();
}
