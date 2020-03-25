package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.AdminDao;
import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public String addNewAdmin(Admin admin) {
        if (admin != null) {
            if (null != adminDao.addNewAdmin(admin) && admin.getEmail() != null
                    && admin.getName() != null && admin.getPassword() != null &&
                    admin.getEmail() != "" && admin.getName() != "" && admin.getPassword() != "")
                return "New Admin Successfully Added In System";
            else
                return "Not Submitted Successfully";
        } else
            throw new IllegalArgumentException();
    }

    @Override
    public String removeAdmin(int adminId) {
        if (adminId > 0) {
            if (adminDao.removeAdmin(adminId) != null)
                return "Admin Successfully deleted";
            else
                return "Cannot Delete Admin";
        } else
            throw new IllegalArgumentException();
    }

    @Override
    public String addNewDvd(Dvd dvd) {
        if (dvd != null) {
            if (null != adminDao.addNewDvd(dvd))
                return "Dvd Added Successfully";
            else
                return "Dvd not Added";
        } else
            throw new IllegalArgumentException();
    }

    @Override
    public String removeDvd(int dvdId) {
        if (dvdId > 0) {
            if (adminDao.removeDvd(dvdId) != null)
                return "Dvd Successfully deleted";
            else
                return "Cannot delete Dvd";
        } else
            throw new IllegalArgumentException();
    }

    @Override
    public Dvd updateDvd(int dvdId, Dvd DvdDetails) {
        Dvd dvd;
        if (DvdDetails != null && dvdId > 0) {
            if (null != ( dvd = adminDao.getDvd(dvdId))) {
                dvd.setTitle(DvdDetails.getTitle());
                dvd.setDirector(DvdDetails.getDirector());
                dvd.setActor(DvdDetails.getActor());
                dvd.setLanguage(DvdDetails.getLanguage());
                dvd.setDescription(DvdDetails.getDescription());
                dvd.setRentalRate(DvdDetails.getRentalRate());
                dvd.setGenre(DvdDetails.getGenre());
                dvd.setRating(DvdDetails.getRating());
                dvd.setRentalDuration(DvdDetails.getRentalDuration());
                dvd.setYear(DvdDetails.getYear());
                return adminDao.updateDvd(dvd);
            }
            else
            {
               throw new ResourceNotFoundException("Dvd not found for this id :: " + dvdId);
            }
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

}
