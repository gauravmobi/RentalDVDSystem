package com.mobiquity.rentaldvdstore.dao;

import com.mobiquity.rentaldvdstore.pojo.Dvd;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SearchDvdDao {
    public List<Dvd> selectDvdByCriteria(Map<String, String> categoryMap);
}
