package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.pojo.Dvd;

public interface AdminService {
    public String addNewAdmin(Admin admin);

    public String removeAdmin(int adminId);
    public String addNewDvd(Dvd dvd);
    public String removeDvd(int dvdId);
    public Dvd updateDvd(int dvdId,Dvd dvd);
}
