package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.pojo.Dvd;

public interface AdminDao {
    public String addNewAdmin(Admin admin);

    public String removeAdmin(int adminId);

    public String addNewDvd(Dvd dvd);

    public String removeDvd(int dvdId);
}
