package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class ListingServiceImplTest {

    private ListingServiceImpl listingService = new ListingServiceImpl();

    @Mock
    private ListingDao listingDao;

    @Before
    public void setup() {
        listingService.setListingDao(listingDao);
        Dvd dvd = new Dvd();
    }

    @Test
    public void testGetAllFilms() {
        List<Dvd> films = new ArrayList<Dvd>();
        films.add(addvalue("ABCD", "good movie", 2012, 5, 100, 2.5));
        films.add(addvalue("ABCD2", "good movie too", 2016, 5, 500, 4.5));
        Mockito.when(listingDao.getAllFilms()).thenReturn(films);
        assertEquals(films, listingService.getAllFilms());
    }

    private Dvd addvalue(String titleName, String description, int year, int duration, int rate, double rating) {
        Dvd dvd = new Dvd();
        dvd.setTitle(titleName);
        dvd.setDescription(description);
        dvd.setReleaseYear(year);
        dvd.setRentalDuration(duration);
        dvd.setRentalRate(rate);
        dvd.setRating(rating);
        return dvd;
    }

    @Test
    public void testGetAllCustomers(){

        List<Customer> customerList = new ArrayList<>();
        customerList.add(addCustomer("dipak","Balsa ntosh","diapk@gmail",false,"karad","1234567890"));
        customerList.add(addCustomer("nisarg","Turke","nisarg@gmail",true,"pune","0123456789"));
        Mockito.when(listingDao.getAllCustomers()).thenReturn(customerList);
        assertEquals(customerList,listingService.getAllCustomers());
    }

    private Customer addCustomer(String firstName, String lastName, String email, Boolean active, String address, String mobileNo) {
        Customer customer = new Customer();
        Address address1 = new Address();
        address1.setAddress(address);
        customer.setActive(active);
        customer.setAddress_id(address1);
        customer.setEmail(email);
        customer.setFirst_name(firstName);
        customer.setLast_name(lastName);
        customer.setMobile_no(mobileNo);
        return  customer;
    }



}