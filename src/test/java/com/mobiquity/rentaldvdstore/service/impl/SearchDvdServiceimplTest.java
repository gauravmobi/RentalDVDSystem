package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.enums.Language;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private Map<String,String> categoryMap = new HashMap<>();
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
        List<Dvd> dvdList  =new ArrayList<>();
        dvdList.add(dvd);
        categoryMap.put("Genre", Genre.THRILLER.toString());
        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap)).thenReturn(dvdList);
        assertEquals(dvdList,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }
    @Test
    public void testSelectDvdByCriteriaByActor() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setActor("Aamir");
        criteria.setActor("Aamir");
        List<Dvd> dvdList  =new ArrayList<>();
        dvdList.add(dvd);
        categoryMap.put("Actor", criteria.getActor());
        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap)).thenReturn(dvdList);
        assertEquals(dvdList,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }
    @Test
    public void testSelectDvdByCriteriaByYear() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setYear("2010");
        criteria.setYear("2010");
        List<Dvd> dvdList  =new ArrayList<>();
        dvdList.add(dvd);
        categoryMap.put("Year", criteria.getYear());
        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap)).thenReturn(dvdList);
        assertEquals(dvdList,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }

    @Test
    public void testSelectDvdByCriteriaByDirector() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setDirector("Gulzar");
        criteria.setDirector("Gulzar");
        List<Dvd> dvdList  =new ArrayList<>();
        dvdList.add(dvd);
        categoryMap.put("Director", criteria.getDirector());
        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap)).thenReturn(dvdList);
        assertEquals(dvdList,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }
    @Test
    public void testSelectDvdByCriteriaByGenreAndLanguage() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setLanguage(Language.HINDI);
        dvd.setGenre(Genre.THRILLER);
        criteria.setLanguage(Language.HINDI);
        criteria.setGenre(Genre.THRILLER);
        List<Dvd> dvdList  =new ArrayList<>();
        dvdList.add(dvd);
        categoryMap.put("Language", Language.HINDI.toString());
        categoryMap.put("Genre", Genre.THRILLER.toString());
        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap)).thenReturn(dvdList);
        assertEquals(dvdList,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }

    @Test
    public void testSelectDvdByCriteriaByLanguage() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setLanguage(Language.HINDI);
        criteria.setLanguage(Language.HINDI);
        List<Dvd> dvdList  =new ArrayList<>();
        dvdList.add(dvd);
        categoryMap.put("Language", Language.HINDI.toString());
        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap)).thenReturn(dvdList);
        assertEquals(dvdList,searchDvdServiceimpl.selectDvdByCriteria(criteria));
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