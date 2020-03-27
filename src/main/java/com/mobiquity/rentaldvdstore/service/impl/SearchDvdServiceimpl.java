package com.mobiquity.rentaldvdstore.service.impl;

import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.dto.DvdDTO;
import com.mobiquity.rentaldvdstore.helper.PhysicalConstants;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.SearchDvdService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SearchDvdServiceimpl implements SearchDvdService {

    private SearchDvdDao searchDvdDao;
    private ListingDao listingDao;

    public void setListingDao(ListingDao listingDao) {
        this.listingDao = listingDao;
    }

    public void setSearchDvdDao(SearchDvdDao searchDvdDao) {
        this.searchDvdDao = searchDvdDao;
    }

    @Override
    public List<Dvd> selectDvdByCriteria(DvdDTO dvdDTO) {
        HashMap<String, String> categoryMap = new HashMap<>();
        System.out.println(dvdDTO.toString());
        if (dvdDTO != null) {
            if (dvdDTO.getGenre() != null) {
                categoryMap.put(PhysicalConstants.GENRE, dvdDTO.getGenre().toString());
            }
            if (dvdDTO.getLanguage() != null) {
                categoryMap.put(PhysicalConstants.LANGUAGE, dvdDTO.getLanguage().toString());
            }
            if (dvdDTO.getActor() != null) {
                categoryMap.put(PhysicalConstants.ACTOR, dvdDTO.getActor());
            }
            if (dvdDTO.getDirector() != null) {
                categoryMap.put(PhysicalConstants.DIRECTOR, dvdDTO.getDirector());
            }
            if (dvdDTO.getYear() != null) {
                categoryMap.put(PhysicalConstants.YEAR, dvdDTO.getYear());
            }
            if (categoryMap.isEmpty()) {
                return listingDao.getAllFilms();
            } else {
                return searchDvdDao.selectDvdByCriteria(categoryMap);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
