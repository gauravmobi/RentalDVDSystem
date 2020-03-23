package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.CustomerDao;
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

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class CustomerServiceImplTest {

    CustomerServiceImpl service=new CustomerServiceImpl();

    @Mock
    CustomerDao customerDao;

    @Before
    public void setup(){
        service.setCustomerDao(customerDao);
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
    public void testForDeleteCustomerWhenCustomerIDisPresent(){
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "wagholi", "pune",
                410000, "pune", city);
        Customer customer = getCustomerObject(1L, "nisarg", "turke", "nisarg@gmail.com",
                true, "nisarg123", "8975965296", address);

        Mockito.when(customerDao.deleteCustomer(customer.getCustomerId())).thenReturn("customer with id " +customer.getCustomerId()+" deleted successfully");
        assertEquals("customer with id " +customer.getCustomerId()+" deleted successfully",service.deleteCustomerService(customer.getCustomerId()));
    }

    @Test
    public void testForDeleteCustomerWhenCustomerIDisNotPresent(){
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "wagholi", "pune",
                410000, "pune", city);
        Customer customer = getCustomerObject(1L, "nisarg", "turke", "nisarg@gmail.com",
                true, "nisarg123", "8975965296", address);

        Mockito.when(customerDao.deleteCustomer(customer.getCustomerId())).thenReturn("record not found. failed to delete");
        assertEquals("record not found. failed to delete",service.deleteCustomerService(customer.getCustomerId()));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testForDeleteCustomerWhenCustomerIDisNull(){
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "wagholi", "pune",
                410000, "pune", city);
        Customer customer = getCustomerObject(null, "nisarg", "turke", "nisarg@gmail.com",
                true, "nisarg123", "8975965296", address);

        assertEquals(IllegalArgumentException.class,service.deleteCustomerService(customer.getCustomerId()));
    }





}