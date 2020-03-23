package com.mobiquity.rentaldvdstore.Integration;

import com.mobiquity.rentaldvdstore.pojo.Address;
import com.mobiquity.rentaldvdstore.pojo.City;
import com.mobiquity.rentaldvdstore.pojo.Country;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerIntegrationTest {
    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost:8080/api";
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
    public void testGetAllCustomers(){
        RequestSpecification specification = RestAssured.given();
        Response response = specification.request(Method.GET,"/customers");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testgetDvdRentedCustomerList() {
        RequestSpecification specification = RestAssured.given();
        Response response = specification.request(Method.GET, "/rental");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void testAddCustomer(){
        RequestSpecification specification = RestAssured.given();
        Customer customer = new Customer();
        Header header = new Header("Content-Type","application/json");
        specification.body(customer);
        specification.header(header);
        Response response = specification.request(Method.POST,"/register");
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testDeleteCustomer(){
        Country country = getCountryObject(1, "India");
        City city = getCityObject(111, "Pune", country);
        Address address = getAddressObject(3, "wagholi", "pune",
                410000, "pune", city);
        Customer customer = getCustomerObject(1L, "nisarg", "turke", "nisarg@gmail.com",
                true, "nisarg123", "8975965296", address);


        RequestSpecification specification = RestAssured.given();
        Header header = new Header("Content-Type","application/json");
        specification.body(customer.getCustomerId());
        specification.header(header);
        Response response = specification.request(Method.DELETE,"delete/1");
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
