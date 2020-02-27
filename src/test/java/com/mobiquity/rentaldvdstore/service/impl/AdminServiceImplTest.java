package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.AdminDao;
import com.mobiquity.rentaldvdstore.pojo.Admin;
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
public class AdminServiceImplTest {

    private AdminServiceImpl adminService = new AdminServiceImpl();

    //test
    //new commir\t here
    @Mock
    AdminDao adminDao;

    @Before
    public void setup() {
        adminService.setAdminDao(adminDao);
    }

    @Test
    public void testAddNewAdmin() {
        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("Admin@123");
        Mockito.when(adminDao.addNewAdmin(admin)).thenReturn("New Admin Successfully Added In System");
        assertEquals("New Admin Successfully Added In System", adminService.addNewAdmin(admin));
    }

    @Test
    public void testAddNewAdminWithoutEmail() {
        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setPassword("Admin@123");
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test
    public void testAddNewAdminWithoutName() {
        Admin admin = new Admin();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("Admin@123");
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test
    public void testAddNewAdminWithoutPassword() {
        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setEmail("admin@gmail.com");
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test
    public void testAddNewAdminWithBlankEmail() {
        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setEmail("");
        admin.setPassword("Admin@123");
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test
    public void testAddNewAdminWithBlankName() {
        Admin admin = new Admin();
        admin.setName("");
        admin.setEmail("admin@gmail.com");
        admin.setPassword("Admin@123");
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test
    public void testAddNewAdminWithBlankPassword() {
        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword(" ");
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test
    public void testAddNewAdminWithBlankFields() {
        Admin admin = new Admin();
        admin.setName(" ");
        admin.setEmail(" ");
        admin.setPassword(" ");
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEmptyNewAdmin() {
        Admin admin = null;
        adminService.addNewAdmin(admin);
    }

    @Test
    public void testAddNewAdminWithoutData() {
        Admin admin = new Admin();
        assertEquals("Not Submitted Successfully", adminService.addNewAdmin(admin));
    }

    @Test
    public void testremoveAdmin() {
        Mockito.when(adminDao.removeAdmin(1)).thenReturn("Admin Successfully deleted");
        assertEquals("Admin Successfully deleted", adminService.removeAdmin(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testremoveAdminByFalseValue() {
        adminService.removeAdmin(-1);
    }

    @Test
    public void testForAdminWhichNotPresent() {
        Mockito.when(adminDao.removeAdmin(5)).thenReturn(null);
        assertEquals("Cannot Delete Admin", adminService.removeAdmin(5));
    }
}

