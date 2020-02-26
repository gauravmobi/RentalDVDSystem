package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.pojo.Rental;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingDao {
    List<Dvd> getAllFilms();

    List<Rental> getDvdRentedCustomersList();

    List<Customer> getAllCustomers();

    public List<Customer> getListOfAllActiveCustomers();
}
