package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Criteria;
import com.mobiquity.rentaldvdstore.pojo.Dvd;

import java.util.List;
import java.util.Map;

public interface SearchDvdDao {
    public List<Dvd> selectDvdByCriteria(Map<String,String> map);
}
