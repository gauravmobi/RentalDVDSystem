package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class ListingServiceImplTest {

    private ListingServiceImpl listingService = new ListingServiceImpl();

    @Mock
    private ListingDao listingDao;

    @Before
    public void setup() {
        listingService.setListingDao(listingDao);
        Dvd dvd = new Dvd();
    }

    @Test
    public void testGetAllFilms() {
        List<Dvd> films = new ArrayList<Dvd>();
        films.add(addvalue("ABCD", "good movie", 2012, 5, 100, 2.5));
        films.add(addvalue("ABCD2", "good movie too", 2016, 5, 500, 4.5));
        Mockito.when(listingDao.getAllFilms()).thenReturn(films);
        assertEquals(films, listingService.getAllFilms());
    }

    @Test(expected = RuntimeException.class)
    public void testForEmptyList() {
        listingService.getAllFilms();
    }

    private Dvd addvalue(String titleName, String description, int year, int duration, int rate, double rating) {
        Dvd dvd = new Dvd();
        dvd.setTitle(titleName);
        dvd.setDescription(description);
        dvd.setReleaseYear(year);
        dvd.setRentalDuration(duration);
        dvd.setRentalRate(rate);
        dvd.setRating(rating);
        return dvd;
    }


}