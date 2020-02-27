package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ListingService {
    List<Dvd> getAllFilms();
    List<Customer> getAllCustomers();
}
