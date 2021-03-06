package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.AdminDao;
import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
