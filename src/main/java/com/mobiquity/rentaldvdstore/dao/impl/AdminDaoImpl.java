package com.mobiquity.rentaldvdstore.dao.impl;

import com.mobiquity.rentaldvdstore.dao.AdminDao;
import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.repository.AdminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AdminDaoImpl implements AdminDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AdminRepository adminRepository;


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

    @Transactional
    @Override
    public Dvd updateDvd(Dvd DvdDetails) {
        return adminRepository.save(DvdDetails);
    }

    @Transactional
    @Override
    public Dvd getDvd(int dvdId) {
        return adminRepository.findById(dvdId).orElseThrow(() -> new ResourceNotFoundException("Dvd not found for this id :: " + dvdId));
    }
}
