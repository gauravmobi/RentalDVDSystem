package com.mobiquity.rentaldvdstore.Integration;




import com.mobiquity.rentaldvdstore.RentalDvdStoreApplication;
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
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.Assert.*;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RentalDvdStoreApplication.class ,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationBySpringTest {



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





    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();


    @Test
    public void testForAddCustomer(){

        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(1213L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        ResponseEntity<String> responseEntity = this.restTemplate
                .postForEntity("http://localhost:8080/api" + port + "/registration", customer, String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:8080/api/" + port + uri;
    }






}
