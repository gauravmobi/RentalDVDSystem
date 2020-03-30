package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.LoginDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class LoginServiceImplTest {
    @Autowired
    LoginServiceImpl loginService;
    @Mock
    LoginDao loginDao;

    @Before
    @Test
    public void setup() {
        loginService.setLoginDao(loginDao);
    }

    @Test
    public void testLoginCustomer() {
        Mockito.when(loginDao.validateUser("nisarg@gmail.com","abcW$1")).thenReturn("abcW$1");
        assertEquals("login successful", loginService.validateUser("nisarg@gmail.com", "abcW$1"));
    }

    @Test
    public void testLoginCustomerInvalidEmailAndPassword() {
        Mockito.when(loginDao.validateUser("abc@gmail.com", "abcW$1")).thenReturn("invalid email or password. failed to login");
        assertEquals("login failed", loginService.validateUser("abc@gmail.com", "abcW$1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLoginCustomerWhenEmailAndPasswordIsNull() {
        loginService.validateUser(null,null);
    }

}
