package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class LoginServiceImplTest {
    LoginServiceImpl service = new LoginServiceImpl();
    @Mock
    LoginDao loginDao;

    @Before
    @Test
    public void setup() {
        service.setLoginDao(loginDao);
    }

    @Test
    public void testLoginByUsername() {
        Mockito.when(loginDao.getPasswordByUsername("gaurav")).thenReturn("gaurav");
        assertEquals("Login Successfully", service.testLoginCredentials("gaurav", "gaurav"));
    }

    @Test
    public void testLoginByInvalidUsername() {
        Mockito.when(loginDao.getPasswordByUsername("gaurav")).thenReturn("gaurav");
        assertEquals("Invalid Username/Password", service.testLoginCredentials("saurav", "gaurav"));
    }

    @Test
    public void testLoginByInvalidPassword() {
        Mockito.when(loginDao.getPasswordByUsername("gaurav")).thenReturn("gaurav");
        assertEquals("Invalid Username/Password", service.testLoginCredentials("gaurav", "saurav"));
    }

}
