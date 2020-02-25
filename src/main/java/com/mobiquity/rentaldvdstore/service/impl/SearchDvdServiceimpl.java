package com.mobiquity.rentaldvdstore.service.impl;


import com.mobiquity.rentaldvdstore.dao.ListingDao;
import com.mobiquity.rentaldvdstore.dao.SearchDvdDao;
import com.mobiquity.rentaldvdstore.pojo.Criteria;
import com.mobiquity.rentaldvdstore.pojo.Dvd;
import com.mobiquity.rentaldvdstore.service.SearchDvdService;

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

        if(criteria != null){
            if(criteria.getGenre() != null){

            }else if(criteria.getLanguage() != null){

            }else if(criteria.getActor() != null){

            }else if(criteria.getDirector() != null){

            }else if(criteria.getYear() != null){

            }else {
                return listingDao.getAllFilms();
            }

        }else {
            throw new IllegalArgumentException();
        }
        return  null;
    }
}
