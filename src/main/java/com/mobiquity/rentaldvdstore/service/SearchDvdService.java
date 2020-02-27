package com.mobiquity.rentaldvdstore.service;

import com.mobiquity.rentaldvdstore.dto.DvdDTO;
import com.mobiquity.rentaldvdstore.pojo.Dvd;

import java.util.List;

public interface SearchDvdService {

    public List<Dvd> selectDvdByCriteria(DvdDTO dvdDTO);
}
