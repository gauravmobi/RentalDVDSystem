package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TestRegistrationDao {
    @Autowired
    private ListingDao listingDao;

    @Autowired
    private RegistrationDao registrationDao;

    private Customer getCustomerObject(Long id, String fname, String lname, String email, Boolean active, String password,
                                       String mobno, Address address) {
        Customer customer = new Customer();
        customer.setCustomer_id(id);
        customer.setFirst_name(fname);
        customer.setLast_name(lname);
        customer.setActive(active);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setMobile_no(mobno);
        customer.setAddress_id(address);
        return customer;
    }

    private Address getAddressObject(int addressid, String add, String district, int postalcode, String location,
                                     City city) {
        Address address = new Address();
        address.setAddress_id(addressid);
        address.setAddress(add);
        address.setDistrict(district);
        address.setPostal_code(postalcode);
        address.setLocation(location);
        address.setCity_id(city);
        return address;
    }

    private City getCityObject(int cityid, String cityname, Country country) {
        City city = new City();
        city.setCity_id(cityid);
        city.setCity(cityname);
        city.setCountry_id(country);
        return city;
    }

    private Country getCountryObject(int countryid, String countryname) {
        Country country = new Country();
        country.setCountry_id(countryid);
        country.setCountry(countryname);
        return country;
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testAddDepartment()
    {
        Customer customer=new Customer();

        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        String check=registrationDao.userRegistration(customer);
        //List<Customer> customers = listingDao.getAllCustomers();
        Assert.assertEquals("Customer Registered Successfully", check);
    }
}
