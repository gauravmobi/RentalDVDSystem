package com.mobiquity.rentaldvdstore.pojo;

import com.mobiquity.rentaldvdstore.enums.Genre;
import com.mobiquity.rentaldvdstore.enums.Language;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name ="Criteria")
public class Criteria {
    @Enumerated(EnumType.ORDINAL)
    private Genre genre;
    @Enumerated(EnumType.ORDINAL)
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
        return "Criteria{" +
                "genre=" + genre +
                ", language=" + language +
                ", actor='" + actor + '\'' +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
