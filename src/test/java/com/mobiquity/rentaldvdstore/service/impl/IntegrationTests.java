package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.impl.ListingDaoImpl;
import com.mobiquity.rentaldvdstore.service.ListingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class IntegrationTests {

    ListingDao listingDao = new ListingDaoImpl();

    ListingServiceImpl listingService = new ListingServiceImpl();

    @Test
    public void testGetAllCustomersFromDb(){
        listingService.setListingDao(listingDao);
        System.out.println(listingService.getAllCustomers());
    }
}
