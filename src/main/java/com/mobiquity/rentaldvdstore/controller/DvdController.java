package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DvdController {
    @Autowired
    ListingService listingService;
    @GetMapping("dvd")
    public List<Dvd> getAllFilms(){
        return listingService.getAllFilms();
    }
}
