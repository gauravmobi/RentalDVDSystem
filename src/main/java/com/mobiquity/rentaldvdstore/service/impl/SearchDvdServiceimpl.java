package com.mobiquity.rentaldvdstore.service.impl;


import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.dto.DvdDTO;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.SearchDvdService;

import java.util.HashMap;
import java.util.List;

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
        if (dvdDTO != null) {
            if (dvdDTO.getGenre() != null) {
                categoryMap.put("Genre", dvdDTO.getGenre().toString());

            }
            if (dvdDTO.getLanguage() != null) {
                categoryMap.put("Language", dvdDTO.getLanguage().toString());

            }
            if (dvdDTO.getActor() != null) {
                categoryMap.put("Actor", dvdDTO.getActor());

            }
            if (dvdDTO.getDirector() != null) {
                categoryMap.put("Director", dvdDTO.getDirector());

            }
            if (dvdDTO.getYear() != null) {
                categoryMap.put("Year", dvdDTO.getYear());

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
