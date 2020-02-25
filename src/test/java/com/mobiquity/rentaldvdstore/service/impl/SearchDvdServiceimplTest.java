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
import java.util.Arrays;
import java.util.HashMap;
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

    @Test
    public void testSelectDvdByCriteriaByGenre() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();
        dvd.setGenre(Genre.THRILLER);
        criteria.setGenre(Genre.THRILLER);
        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Genre",criteria.getGenre().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }

    @Test
    public void testSelectDvdByCriteriaByLanguage() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();

        dvd.setLanguage(Language.ENGLISH);
        criteria.setLanguage(Language.ENGLISH);

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Language",criteria.getLanguage().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }

    @Test
    public void testSelectDvdByCriteriaByActor() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();

        dvd.setActor("Amir Khan");
        criteria.setActor("Amir Khan");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Actor",criteria.getActor().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }

    @Test
    public void testSelectDvdByCriteriaByDirector() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();

        dvd.setDirector("SLB");
        criteria.setDirector("SLB");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Director",criteria.getDirector().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }

    @Test
    public void testSelectDvdByCriteriaByYear() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();

        dvd.setYear("2010");
        criteria.setYear("2010");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Year",criteria.getYear().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }

    @Test
    public void testSelectDvdByAllCriteria() {
        Criteria criteria = new Criteria();
        Dvd dvd = new Dvd();

        dvd.setGenre(Genre.THRILLER);
        criteria.setGenre(Genre.THRILLER);

        dvd.setLanguage(Language.ENGLISH);
        criteria.setLanguage(Language.ENGLISH);

        dvd.setActor("Amir Khan");
        criteria.setActor("Amir Khan");

        dvd.setDirector("SLB");
        criteria.setDirector("SLB");

        dvd.setYear("2010");
        criteria.setYear("2010");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Genre",criteria.getGenre().toString());
        categoryMap.put("Language",criteria.getLanguage().toString());
        categoryMap.put("Actor",criteria.getActor());
        categoryMap.put("Director",criteria.getDirector());
        categoryMap.put("Year",criteria.getYear());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(criteria));
    }
}