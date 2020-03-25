package com.mobiquity.rentaldvdstore.Controller;


import com.mobiquity.rentaldvdstore.controller.CustomerController;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.impl.ListingServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
@SpringBootTest(classes = {ListingServiceImpl.class})
public class Customer_GetAllCustomers_ByMockMVC {

    @Autowired
    private MockMvc mvc;

    private ListingServiceImpl listingService = new ListingServiceImpl();

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
    public void getAllEmployeesAPI() throws Exception{

        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer1 = getCustomerObject(1213L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        Country country2 = getCountryObject(1, "India");
        City city2 = getCityObject(111, "Pune", country);
        Address address2 = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer2 = getCustomerObject(1213L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);



        List listOfAllCustomers = new ArrayList();
        listOfAllCustomers.add(customer1);
        listOfAllCustomers.add(customer2);



        Mockito.when(listingService.getAllCustomers()).thenReturn(listOfAllCustomers);


        mvc.perform(MockMvcRequestBuilders
                .get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
