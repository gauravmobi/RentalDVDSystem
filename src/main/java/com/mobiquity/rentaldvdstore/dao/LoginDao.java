package com.mobiquity.rentaldvdstore.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    public String getPasswordByUsername(String username);
}
