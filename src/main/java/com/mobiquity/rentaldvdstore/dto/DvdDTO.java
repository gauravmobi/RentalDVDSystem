package com.mobiquity.rentaldvdstore.dto;

import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.enums.Language;

public class DvdDTO {
    private Genre genre;
    private Language language;
    private String actor;
    private String director;
    private String year;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "DvdDTO{" +
                "genre=" + genre +
                ", language=" + language +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
