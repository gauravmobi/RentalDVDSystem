package com.mobiquity.rentaldvdstore.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    public String testLoginCredentials(String username, String password);
}
