package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        dvd.setRentalDuration(duration);
        dvd.setRentalRate(rate);
        dvd.setRating(rating);
        return dvd;
    }

    private Rental addRentalList(int rental_id, String rental_date, Long customer_id, String return_date,
                                 int dvdid) {
        Rental rental = new Rental();
        Customer customer = new Customer();
        Date date = new Date();
        Dvd dvd = new Dvd();

        customer.setCustomerId(customer_id);
        dvd.setFilmId(dvdid);

        rental.setRental_id(rental_id);
        rental.setRental_date(rental_date);
        rental.setCustomer_id(customer);
        rental.setReturn_date(return_date);
        rental.setDvdid(dvd);
        return rental;
    }

    @Test
    public void testDvdRentedCustomersList() {
        List<Rental> rentalList = new ArrayList<>();

        rentalList.add(addRentalList(1, "1/1/2000", 1L, "1/2/2000", 1));
        rentalList.add(addRentalList(2, "1/1/2002", 2L, "1/2/2002", 1));
        rentalList.add(addRentalList(3, "1/1/2004", 3L, "1/2/2004", 1));

        Mockito.when(listingDao.getDvdRentedCustomersList()).thenReturn(rentalList);
        assertEquals(rentalList, listingService.getDvdRentedCustomersList());
    }

    private Customer getCustomerObject(Long id, String fname, String lname, String email, Boolean active, String password,
                                       String mobno, Address address) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setActive(active);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setMobileNo(mobno);
        customer.setAddressId(address);
        return customer;
    }

    private Address getAddressObject(int addressid, String add, String district, int postalcode, String location,
                                     City city) {
        Address address = new Address();
        address.setAddressId(addressid);
        address.setAddress(add);
        address.setDistrict(district);
        address.setPostal_code(postalcode);
        address.setLocation(location);
        address.setCity_id(city);
        return address;
    }

    private City getCityObject(int cityid, String cityname, Country country) {
        City city = new City();
        city.setCityId(cityid);
        city.setCity(cityname);
        city.setCountry(country);
        return city;
    }

    private Country getCountryObject(int countryid, String countryname) {
        Country country = new Country();
        country.setCountryId(countryid);
        country.setCountry(countryname);
        return country;
    }


    @Test
    public void testGetAllCustomers() {
        List<Customer> customerList = new ArrayList<>();

        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);

        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                false, "abcW$1", "+919999999999", address);

        Country country2 = getCountryObject(1, "India");
        City city2 = getCityObject(111, "Pune", country);
        Address address2 = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer2 = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);


        customerList.add(customer);
        customerList.add(customer2);
        Mockito.when(listingDao.getAllCustomers()).thenReturn(customerList);
        assertEquals(customerList, listingService.getAllCustomers());
    }

    @Test
    public void testGetListOfAllActiveCustomers() {
        List<Customer> listofActiveCustomers = new ArrayList<>();
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);

        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                false, "abcW$1", "+919999999999", address);

        Country country2 = getCountryObject(1, "India");
        City city2 = getCityObject(111, "Pune", country);
        Address address2 = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer2 = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        listofActiveCustomers.add(customer);
        listofActiveCustomers.add(customer2);

        Mockito.when(listingDao.getListOfAllActiveCustomers()).thenReturn(listofActiveCustomers);
        assertEquals(listofActiveCustomers, listingService.getListOfAllActiveCustomers());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForCustomerListIsNull() {

        Mockito.when(listingDao.getListOfAllActiveCustomers()).thenReturn(null);
        listingService.getListOfAllActiveCustomers();
    }

    @Test
    public void testForNoActiveCustomerFound() {
        List<Customer> listofActiveCustomers = new ArrayList<>();
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);

        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                false, "abcW$1", "+919999999999", address);

        Country country2 = getCountryObject(1, "India");
        City city2 = getCityObject(111, "Pune", country);
        Address address2 = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer2 = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                false, "abcW$1", "+919999999999", address);

        listofActiveCustomers.add(customer);
        listofActiveCustomers.add(customer2);

        Mockito.when(listingDao.getListOfAllActiveCustomers()).thenReturn(listofActiveCustomers);
        assertEquals(listofActiveCustomers, listingService.getListOfAllActiveCustomers());
    }
}