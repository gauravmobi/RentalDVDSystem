package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Admin;

public interface AdminService {
    public String addNewAdmin(Admin admin);
    public String removeAdmin(int adminId);
}
