package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.service.ListingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = SearchController.class)
public class SearchControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ListingService listingService;

    @Test
    public void findCustomersByNameCorrectAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/admin/customers?name=")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void findCustomersByNameInCorrectAPI() throws Exception {
        mvc.perform( MockMvcRequestBuilders
                .get("/admin/customer")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}