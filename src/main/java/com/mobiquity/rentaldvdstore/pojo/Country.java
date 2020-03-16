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

    @OneToMany(cascade = {CascadeType.ALL},fetch= FetchType.EAGER, mappedBy = "country")
    private List<City> city;

    public List<City> getCity() {
        return city;
    }
    public void setCity(List<City> city) {
        this.city = city;
    }

    public Country() {
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
