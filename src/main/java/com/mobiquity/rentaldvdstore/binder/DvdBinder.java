package com.mobiquity.rentaldvdstore.binder;

import com.mobiquity.rentaldvdstore.dto.DvdDTO;
import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.enums.Language;
import com.mobiquity.rentaldvdstore.pojo.Dvd;

import java.util.List;

public class DvdBinder {

    public Dvd getDvdFromDTO(DvdDTO dvdDTO) {
        Dvd dvd = new Dvd();
        dvd.setActor(dvdDTO.getActor());
        dvd.setYear(dvdDTO.getYear());
        dvd.setDirector(dvdDTO.getDirector());
        dvd.setLanguage(dvdDTO.getLanguage());
        dvd.setGenre(dvdDTO.getGenre());
        return dvd;
    }
}
