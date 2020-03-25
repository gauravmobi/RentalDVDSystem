package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.AdminDao;
import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.enums.Language;
import com.mobiquity.rentaldvdstore.pojo.Admin;
import com.mobiquity.rentaldvdstore.pojo.Dvd;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class AdminServiceImplTest {

    private AdminServiceImpl adminService = new AdminServiceImpl();

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

    @Test
    public void testForUpdateDvd() {
        Dvd dvd = new Dvd();
        dvd.setDvdId(1);
        dvd.setTitle("ABCD");
        dvd.setDirector("SS");
        dvd.setActor("VARUN DHAVAN");
        dvd.setLanguage(Language.HINDI);
        dvd.setDescription("DANCE MOVIE");
        dvd.setRentalRate(50);
        dvd.setGenre(Genre.HORROR);
        dvd.setRating(4.2);
        dvd.setRentalDuration(5);
        dvd.setYear("2012");

        Dvd dvdDetails = new Dvd();
        dvdDetails.setDvdId(1);
        dvdDetails.setTitle("ABCDa");
        dvdDetails.setDirector("SSa");
        dvdDetails.setActor("VARUN DHAVANa");
        dvdDetails.setLanguage(Language.HINDI);
        dvdDetails.setDescription("DANCE MOVIEa");
        dvdDetails.setRentalRate(55);
        dvdDetails.setGenre(Genre.HORROR);
        dvdDetails.setRating(4.3);
        dvdDetails.setRentalDuration(6);
        dvdDetails.setYear("2011");

        Mockito.when(adminDao.getDvd(1)).thenReturn(dvd);
        Mockito.when(adminDao.updateDvd(dvdDetails)).thenReturn(dvdDetails);
        assertEquals(null, adminService.updateDvd(1, dvdDetails));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testForUpdateDvdIfDvdNotFound() {
        Dvd dvd =new Dvd();
        Mockito.when(adminDao.getDvd(888)).thenReturn(null);
        adminService.updateDvd(888, dvd);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testForUpdateDvdWithNullDvdObject() {
        Dvd dvd =null;
        adminService.updateDvd(12, dvd);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForUpdateDvdWithInvalidDvdId() {
        Dvd dvd =new Dvd();
        adminService.updateDvd(-1, dvd);
    }
}
