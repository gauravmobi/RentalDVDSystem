package com.mobiquity.rentaldvdstore.controller;

import com.mobiquity.rentaldvdstore.pojo.Admin;

import com.mobiquity.rentaldvdstore.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("admins")
    public String addAdmin(@RequestBody Admin admin){
        return adminService.addNewAdmin(admin);
    }
}