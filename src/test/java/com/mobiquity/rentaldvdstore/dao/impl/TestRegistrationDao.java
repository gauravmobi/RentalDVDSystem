package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.impl.RegistrationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class TestRegistrationDao {
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private ListingDao listingDao;

    RegistrationServiceImpl service = new RegistrationServiceImpl();
    @Before
    public void setup() {
        service.setRegistrationDao(registrationDao);
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUserRegistration(){
        Customer customer = new Customer();
        Country country = getCountryObject(11, "India");
        City city = getCityObject(211, "Pune", country);
        Address address = getAddressObject(20, "Mumbai", "Sangli",
                415409, "Kolkata", city);
      customer = getCustomerObject(102L, "SAURABH", "K", "saurabh@gmail.com",
                true, "abcW$2", "+919999899999", address);

      service.userRegistration(customer);
        List<Customer> customerList = listingDao.getAllCustomers();
        Assert.assertEquals("Registration Successfull",registrationDao.userRegistration(customer));

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
        customer.setAddress(address);
        return customer;
    }

    private Address getAddressObject(int addressid, String add, String district, int postalcode, String location,
                                     City city) {
        Address address = new Address();
        address.setAddressId(addressid);
        address.setAddress(add);
        address.setDistrict(district);
        address.setPostalCode(postalcode);
        address.setLocation(location);
        address.setCity(city);
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
        country.setCountry_id(countryid);
        country.setCountry(countryname);
        return country;
    }

}
