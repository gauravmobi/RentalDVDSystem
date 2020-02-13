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
    Customer customer;

    @Mock
    RegistrationDao registrationDao;

    @Before
    public void setup() {
        service.setRegistrationDao(registrationDao);
    }

    @Test
    public void testSuccessfullyRegistration() {
        customer =  new Customer(101, "Gaurav", "Sonawane", "g@gmail.com", true, "gaurav",
                    new Address(11, "Pune", "Pune",
                    new City(01, "Pune",
                    new Country(111, "India")), 111111, "Pune"));
        Mockito.when(registrationDao.userRegistration(customer)).thenReturn("Success");
        assertEquals("Registration Success", service.userRegistration(customer));
    }

    @Test
    public void testFailRegistration() {
        customer =  new Customer(101, "Gaurav", "Sonawane", "g@gmail.com", true, "gaurav",
                    new Address(11, "Pune", "Pune",
                    new City(01, "Pune",
                    new Country(111, "India")), 111111, "Pune"));
        Mockito.when(registrationDao.userRegistration(customer)).thenThrow(RuntimeException.class);
        assertEquals("Registration Failed", service.userRegistration(customer));
    }
}