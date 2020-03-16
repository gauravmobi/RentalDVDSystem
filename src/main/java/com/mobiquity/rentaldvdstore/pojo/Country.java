package com.mobiquity.rentaldvdstore.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Country")
public class Country extends MetadataPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int countryId;
    private String country;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public Country() {
    }

    public int getCountry_id() {
        return countryId;
    }

    public void setCountry_id(int country_id) {
        this.countryId = country_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
