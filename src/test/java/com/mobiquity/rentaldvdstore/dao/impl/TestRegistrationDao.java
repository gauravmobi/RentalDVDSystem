package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class TestRegistrationDao {
    @Autowired
    private ListingDao listingDao;

    @Autowired
    private RegistrationDao registrationDao;

    private Customer getCustomerObject(Long id, String fname, String lname, String email, Boolean active, String password,
                                       String mobno, Address address) {
        Customer customer = new Customer();
        customer.setCustomerId(id);
        customer.setFirstName(fname);
        customer.setLastName(lname);
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
    @Transactional
    @Rollback(true)
    public void testAddDepartment()
    {
        Customer customer=new Customer();

        Country country = getCountryObject(9, "India");
        City city = getCityObject(22, "Pune", country);
        Address address = getAddressObject(8, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        customer = getCustomerObject(6101L, "abc", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        //List<Customer> customers = listingDao.getAllCustomers();
        Assert.assertEquals("Customer Registered Successfully", registrationDao.userRegistration(customer));
    }
}
