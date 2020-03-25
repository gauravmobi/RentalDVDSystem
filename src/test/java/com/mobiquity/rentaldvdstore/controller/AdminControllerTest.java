package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AdminController adminController;

    @Test
   public void updateDvd() {

    }

    @Test
    public void getAllDvds() throws Exception {
        Dvd dvd = new Dvd();
        dvd.setGenre(Genre.HORROR);

        List<Dvd> Dvds= Collections.singletonList(dvd);

        given(adminController.getAllDvds()).willReturn(Dvds);

        mockMvc.perform(get("http://localhost:8080/api/dvds")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}