package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Admin;

import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.repository.AdminRepository;
import com.mobiquity.rentaldvdstore.service.AdminService;

import com.mobiquity.rentaldvdstore.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ListingService listingService;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("admins")
    public String addAdmin(@RequestBody Admin admin){
        return adminService.addNewAdmin(admin);
    }


    @PostMapping("dvds")
    public String addDvds(@RequestBody Dvd dvd){
        return adminService.addNewDvd(dvd);
    }


    @DeleteMapping
    @ResponseBody
    public String removeDvds( Dvd id){
        try {
            adminRepository.delete(id);
        }catch (Exception ex){
            return  "Error deleting dvd"+ ex.toString();
        };
        return "Dvd successfully deleted";
    }

    @GetMapping("dvds")
    public List<Dvd> getAllDvds(){
        return listingService.getAllFilms();
    }

    @PutMapping("/dvds/{id}")
    public Dvd updateDvd(@PathVariable(value = "id") int dvdId, @Valid @RequestBody Dvd DvdDetails) {

        return adminService.updateDvd(dvdId, DvdDetails);
    }
}
