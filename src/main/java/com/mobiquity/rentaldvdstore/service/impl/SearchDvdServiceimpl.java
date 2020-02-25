package com.mobiquity.rentaldvdstore.service.impl;


import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.enums.Language;
import com.mobiquity.rentaldvdstore.pojo.Criteria;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.SearchDvdService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<String,String> dvdMap = new HashMap<>();
        if(criteria != null){
            if(criteria.getGenre() != null){
                    dvdMap.put("Genre", criteria.getGenre().toString());

            }if(criteria.getLanguage() != null) {
                dvdMap.put("Language", criteria.getLanguage().toString());

            }if(criteria.getActor() != null){
                dvdMap.put("Actor", criteria.getActor());

            }if(criteria.getDirector() != null){
                dvdMap.put("Director",criteria.getDirector());

            }if(criteria.getYear() != null){
                dvdMap.put("Year", criteria.getYear());

            }if(dvdMap.isEmpty()){
                return listingDao.getAllFilms();
            }else {
                return  searchDvdDao.selectDvdByCriteria(dvdMap);
            }

        }else {
            throw new IllegalArgumentException();
        }

    }
}
