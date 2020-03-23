package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.AdminDao;
import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdminDaoImpl implements AdminDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public String addNewAdmin(Admin admin) {
        entityManager.persist(admin);
        return "Admin Registered Successfully";
    }

    @Override
    public String removeAdmin(int adminId) {
        return null;
    }

    @Override
    public String addNewDvd(Dvd dvd) {
        return null;
    }

    @Override
    public String removeDvd(int dvdId) {
        return null;
    }
}
