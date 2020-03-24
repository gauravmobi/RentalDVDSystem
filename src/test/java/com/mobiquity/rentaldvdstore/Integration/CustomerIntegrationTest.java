package com.mobiquity.rentaldvdstore.Integration;

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

    @Test
    public void testGetAllCustomers(){
        RequestSpecification specification = RestAssured.given();
        Response response = specification.request(Method.GET,"/customers");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
