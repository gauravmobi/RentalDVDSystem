package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.enums.Language;
import com.mobiquity.rentaldvdstore.dto.DvdDTO;
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
        DvdDTO dvdDTO = new DvdDTO();
        Dvd dvd = new Dvd();
        dvd.setGenre(Genre.THRILLER);
        dvdDTO.setGenre(null);
        searchDvdServiceimpl.selectDvdByCriteria(dvdDTO);
    }

    @Test
    public void testSelectDvdByCriteriaWhenAllCriteriaAttrsAreEmpty() {
        DvdDTO dvdDTO = new DvdDTO();
        List<Dvd> dvds = new ArrayList<>();
        Dvd dvd = new Dvd();
        dvds.add(dvd);
        Mockito.when(listingDao.getAllFilms()).thenReturn(dvds);
        assertEquals(dvds, searchDvdServiceimpl.selectDvdByCriteria(dvdDTO));
    }

    @Test
    public void testSelectDvdByCriteriaByGenre() {
        DvdDTO dvdDTO = new DvdDTO();
        Dvd dvd = new Dvd();
        dvd.setGenre(Genre.THRILLER);
        dvdDTO.setGenre(Genre.THRILLER);
        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Genre", dvdDTO.getGenre().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(dvdDTO));
    }

    @Test
    public void testSelectDvdByCriteriaByLanguage() {
        DvdDTO dvdDTO = new DvdDTO();
        Dvd dvd = new Dvd();

        dvd.setLanguage(Language.ENGLISH);
        dvdDTO.setLanguage(Language.ENGLISH);

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Language", dvdDTO.getLanguage().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(dvdDTO));
    }

    @Test
    public void testSelectDvdByCriteriaByActor() {
        DvdDTO dvdDTO = new DvdDTO();
        Dvd dvd = new Dvd();

        dvd.setActor("Amir Khan");
        dvdDTO.setActor("Amir Khan");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Actor", dvdDTO.getActor().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(dvdDTO));
    }

    @Test
    public void testSelectDvdByCriteriaByDirector() {
        DvdDTO dvdDTO = new DvdDTO();
        Dvd dvd = new Dvd();

        dvd.setDirector("SLB");
        dvdDTO.setDirector("SLB");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Director", dvdDTO.getDirector().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(dvdDTO));
    }

    @Test
    public void testSelectDvdByCriteriaByYear() {
        DvdDTO dvdDTO = new DvdDTO();
        Dvd dvd = new Dvd();

        dvd.setYear("2010");
        dvdDTO.setYear("2010");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Year", dvdDTO.getYear().toString());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(dvdDTO));
    }

    @Test
    public void testSelectDvdByAllCriteria() {
        DvdDTO dvdDTO = new DvdDTO();
        Dvd dvd = new Dvd();

        dvd.setGenre(Genre.THRILLER);
        dvdDTO.setGenre(Genre.THRILLER);

        dvd.setLanguage(Language.ENGLISH);
        dvdDTO.setLanguage(Language.ENGLISH);

        dvd.setActor("Amir Khan");
        dvdDTO.setActor("Amir Khan");

        dvd.setDirector("SLB");
        dvdDTO.setDirector("SLB");

        dvd.setYear("2010");
        dvdDTO.setYear("2010");

        List<Dvd> list = new ArrayList<Dvd>();
        list.add(dvd);

        HashMap<String, String> categoryMap=new HashMap<>();
        categoryMap.put("Genre", dvdDTO.getGenre().toString());
        categoryMap.put("Language", dvdDTO.getLanguage().toString());
        categoryMap.put("Actor", dvdDTO.getActor());
        categoryMap.put("Director", dvdDTO.getDirector());
        categoryMap.put("Year", dvdDTO.getYear());

        Mockito.when(searchDvdDao.selectDvdByCriteria(categoryMap))
                .thenReturn(list);
        assertEquals(list,searchDvdServiceimpl.selectDvdByCriteria(dvdDTO));
    }
}