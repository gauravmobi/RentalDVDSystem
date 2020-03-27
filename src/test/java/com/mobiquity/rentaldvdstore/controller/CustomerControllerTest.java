package com.mobiquity.rentaldvdstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobiquity.rentaldvdstore.pojo.Customer;
import com.mobiquity.rentaldvdstore.service.ListingService;
import com.mobiquity.rentaldvdstore.service.LoginService;
import com.mobiquity.rentaldvdstore.service.RegistrationService;
import com.mobiquity.rentaldvdstore.service.SearchDvdService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    ListingService listingService;
    @MockBean
    LoginService loginService;
    @MockBean
    RegistrationService registrationService;
    @MockBean
    SearchDvdService searchDvdService;

    @Test
    public void getAllCustomersWhenCorrectAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/customers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllCustomerWhenIncorrectAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/customer")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void AddCustomersWhenCorrectAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .post("/registration")
                .content(asJsonString(new Customer("firstName",
                        "lastName", "email@mail.com",
                        true,"abcW$1",null,"+919999999999")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void AddCustomersWhenInCorrectAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .post("/registrations")
                .content(asJsonString(new Customer("firstName",
                        "lastName", "email@mail.com",
                        true,"abcW$1",null,"+919999999999")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}