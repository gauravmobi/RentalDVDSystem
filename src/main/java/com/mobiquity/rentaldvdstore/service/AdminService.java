package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.pojo.Dvd;

import java.util.List;

public interface AdminService {
    public String addNewAdmin(Admin admin);
    public String removeAdmin(int adminId);


}
