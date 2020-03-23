package com.mobiquity.rentaldvdstore.integrationtest;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerIntegrationTest {

    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost:8080/api";
    }
    @Test
    public void testGetAllCustomers(){
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"/customers");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test
    public void testgetDvdRentedCustomerList(){
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"/rental");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),404);
    }

    @Test
    public void testAddCustomer(){
        RequestSpecification httprequest = RestAssured.given();
        Customer customer = new Customer();
        Header header = new Header("Content-Type","application/json");
        httprequest.body(customer);
        httprequest.header(header);
        Response response = httprequest.request(Method.POST,"/register");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),404);

    }
}
