package com.mobiquity.rentaldvdstore.integrationtest;

import com.mobiquity.rentaldvdstore.pojo.Customer;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DvdIntegrationTest {

    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost:8080/api";
    }
    @Test
    public void testGetAllFilms(){
        RequestSpecification httprequest = RestAssured.given();
        Response response = httprequest.request(Method.GET,"/dvd");
        String responseBody = response.getBody().asString();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
