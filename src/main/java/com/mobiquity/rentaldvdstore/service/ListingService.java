package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.pojo.Rental;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ListingService {
    List<Dvd> getAllFilms();

    List<Rental> getDvdRentedCustomersList();

    List<Customer> getAllCustomers();

    public List<Customer> getListOfAllActiveCustomers();
}
