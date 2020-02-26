package com.mobiquity.rentaldvdstore.service.impl;


import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.pojo.Criteria;
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
    public List<Dvd> selectDvdByCriteria(Criteria criteria) {
        HashMap<String, String> categoryMap=new HashMap<>();
        if(criteria != null){
            if(criteria.getGenre() != null){
                categoryMap.put("Genre",criteria.getGenre().toString());

            }
            if(criteria.getLanguage() != null){
                categoryMap.put("Language",criteria.getLanguage().toString());

            }
            if(criteria.getActor() != null){
                categoryMap.put("Actor",criteria.getActor());

            }
            if(criteria.getDirector() != null){
                categoryMap.put("Director",criteria.getDirector());

            }
            if(criteria.getYear() != null){
                categoryMap.put("Year",criteria.getYear());

            }
            if(categoryMap.isEmpty()) {
                return listingDao.getAllFilms();
            }
            else {
                return searchDvdDao.selectDvdByCriteria(categoryMap);
            }

        }else {
            throw new IllegalArgumentException();
        }
    }
}
