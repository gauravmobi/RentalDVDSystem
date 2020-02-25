package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.pojo.Criteria;
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
public class SearchDvdServiceimplTest {
    @Mock
    private SearchDvdDao searchDvdDao;
    @Mock
    private ListingDao listingDao;
    private SearchDvdServiceimpl searchDvdServiceimpl = new SearchDvdServiceimpl();

    @Before
    public void setup(){
        searchDvdServiceimpl.setSearchDvdDao(searchDvdDao);
        searchDvdServiceimpl.setListingDao(listingDao);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSelectDvdByCriteria() {
        searchDvdServiceimpl.selectDvdByCriteria(null);
    }

    @Test
    public void testSelectDvdByCriteriaByGenre() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setGenre(Genre.THRILLER);
        criteria.setGenre(Genre.THRILLER);
        searchDvdServiceimpl.selectDvdByCriteria(criteria);
    }
    @Test
    public void testSelectDvdByCriteriaWhenGenreIsEmpty() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setGenre(Genre.THRILLER);
        criteria.setGenre(null);
        searchDvdServiceimpl.selectDvdByCriteria(criteria);
    }

    @Test
    public void testSelectDvdByCriteriaWhenAllCriteriaAttrsAreEmpty() {
        Criteria criteria = new Criteria();
        List<Dvd> dvds = new ArrayList<>();
        Dvd dvd = new Dvd();
        dvds.add(dvd);
        Mockito.when(listingDao.getAllFilms()).thenReturn(dvds);
        assertEquals(dvds, searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }
}