package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class RegistrationServiceImplTest {
    RegistrationServiceImpl service = new RegistrationServiceImpl();
    @Mock
    private RegistrationDao registrationDao;

    @Before
    public void setup() {
        service.setRegistrationDao(registrationDao);
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
        country.setCountryId(countryid);
        country.setCountry(countryname);
        return country;
    }

    @Test
    public void testCustomerRegistration() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        Mockito.when(registrationDao.userRegistration(customer)).thenReturn("Customer Registered Successfully");
        assertEquals("Customer Registered Successfully", service.userRegistration(customer));
    }

    @Test
    public void testCustomerRegistrationFailed() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);
        Mockito.when(registrationDao.userRegistration(customer)).thenReturn("customer registration failed");
        assertEquals("customer registration failed", service.userRegistration(customer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCustomerIsNull() {
        assertEquals(IllegalArgumentException.class, service.userRegistration(null));
    }

    
    @Test
    public void testCustomerRegisteredOrNot() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "gaurav@gmail.com",
                true, "abcW$1", "+919999999999", address);

        Mockito.when(registrationDao.testRegisteredEmailId("gaurav@gmail.com"))
                .thenReturn("gaurav@gmail.com");
        assertEquals("Email Id already Registered",
                service.testRegisteredEmailId(customer.getEmail()));
    }

    @Test
    public void testAlreadyCustomerRegistered() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        Mockito.when(registrationDao.testRegisteredEmailId("gaurav@gmail.com"))
                .thenReturn("gaurav@gmail.com");
        assertEquals("Registration Success",
                service.testRegisteredEmailId(customer.getEmail()));
    }

    @Test
    public void testCorrectEmailPattern() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);
        Mockito.when(registrationDao.userRegistration(customer)).thenReturn("Registration Success");
        assertEquals("Registration Success", service.userRegistration(customer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInCorrectEmailPattern() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abcgmail.com",
                true, "abcW$1", "+919999999999", address);
        assertEquals(IllegalArgumentException.class, service.userRegistration(customer));
    }

    @Test
    public void testCorrectPasswordPattern() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);
        Mockito.when(registrationDao.userRegistration(customer)).thenReturn("Registration Success");
        assertEquals("Registration Success", service.userRegistration(customer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInCorrectPasswordPattern() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abcgmail.com",
                true, "abc", "+919999999999", address);
        assertEquals(IllegalArgumentException.class, service.userRegistration(customer));
    }

    @Test
    public void testCorrectMobileNoPattern() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "9999999999", address);
        Mockito.when(registrationDao.userRegistration(customer)).thenReturn("Registration Success");
        assertEquals("Registration Success", service.userRegistration(customer));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInCorrectMobileNoPattern() {
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(101L, "dipak", "b", "abcgmail.com",
                true, "abcW$1", "9999", address);
        assertEquals(IllegalArgumentException.class, service.userRegistration(customer));
    }

}
