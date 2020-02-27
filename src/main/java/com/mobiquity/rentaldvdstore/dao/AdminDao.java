package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Admin;

public interface AdminDao {
    public String addNewAdmin(Admin admin);

    public String removeAdmin(int adminId);
}
