package com.mobiquity.rentaldvdstore.Controller;

import com.mobiquity.rentaldvdstore.controller.CustomerController;
import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.sort;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    com.mobiquity.rentaldvdstore.controller.CustomerController customerController;
    @Mock
    RegistrationService registrationService;
    @Mock
    ListingService listingService;


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
    public void testForRegisterCustomer() {

        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "a/p Laxmi chowk 32 Shirala", "Sangli",
                415408, "Shirala", city);
        Customer customer = getCustomerObject(1213L, "dipak", "b", "abc@gmail.com",
                true, "abcW$1", "+919999999999", address);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        System.out.println(customer);
        Mockito.when(registrationService.userRegistration(customer)).thenReturn("Customer Registered Successfully");

        ResponseEntity<String> responseEntity = customerController.customerRegistration(customer);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void testForGetAllCustomers() {
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

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Mockito.when(listingService.getAllCustomers()).thenReturn(listOfAllCustomers);
        ResponseEntity<List<Customer>> responseEntity = customerController.getAllCustomers();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void testForGetAllActiveCustomers() {

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
        Customer customer2 = getCustomerObject(1213L, "dipak", "b", "abc@gmail.com", true, "abcW$1", "+919999999999", address);


        List listOfAllActiveCustomers = new ArrayList();
        listOfAllActiveCustomers.add(customer1);
        listOfAllActiveCustomers.add(customer2);


        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Mockito.when(listingService.getListOfAllActiveCustomers()).thenReturn(listOfAllActiveCustomers);
        ResponseEntity<List<Customer>> responseEntity = customerController.getAllActiveCustomers();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }



}
//
