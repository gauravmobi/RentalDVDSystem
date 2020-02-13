package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import com.mobiquity.rentaldvdstore.dao.RegistrationDao;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.impl.LoginServiceImpl;
import com.mobiquity.rentaldvdstore.service.impl.RegistrationServiceImpl;
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
    RegistrationDao registrationDao;
    Customer customer;
    Address address;
    City city;
    Country country;

    @Before
    public void setup() {
        service.setRegistrationDao(registrationDao);
    }

    @Before
    public void prepare() {
        customer = new Customer();
        address = new Address();
        city = new City();
        country = new Country();
    }

    @Test
    public void testSuccessfullyRegistration() {
        customer.setCustomer_id(101);
        customer.setLast_name("Dipak");
        customer.setLast_name("Balsantosh");
        customer.setEmail("dipak@gmail.com");
        customer.setActive(true);
        customer.setPassword("dipak");
        address.setAddress_id(11);
        address.setAddress("a/p Laxmi chowk 32 Shirala");
        address.setDistrict("Sangli");
        address.setPostal_code(415408);
        address.setLocation("Shirala");
        city.setCity_id(111);
        city.setCity("32 Shirala");
        country.setCountry_id(1);
        country.setCountry("India");
        Mockito.when(registrationDao.userRegistration(customer)).thenReturn("Registration Success");
        assertEquals("Registration Success", service.userRegistration(customer));
    }

    @Test
    public void testFailRegistrationWithException() {
        customer.setCustomer_id(101);
        customer.setLast_name("Dipak");
        customer.setLast_name("Balsantosh");
        customer.setEmail("dipak@gmail.com");
        customer.setActive(true);
        customer.setPassword("dipak");
        address.setAddress_id(11);
        address.setAddress("a/p Laxmi chowk 32 Shirala");
        address.setDistrict("Sangli");
        address.setPostal_code(415408);
        address.setLocation("Shirala");
        city.setCity_id(111);
        city.setCity("32 Shirala");
        country.setCountry_id(1);
        country.setCountry("India");
        Mockito.when(registrationDao.userRegistration(customer)).thenThrow(RuntimeException.class);
        assertEquals("Registration Failed", service.userRegistration(customer));
    }
    @Test
    public void testFailRegistrationWithEmpty() {
        Mockito.when(registrationDao.userRegistration(customer)).thenReturn(null);
        assertEquals("Registration Failed", service.userRegistration(customer));
    }

}
