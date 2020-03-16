package com.mobiquity.rentaldvdstore.pojo;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City extends MetadataPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;
    private String city;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countryId")
    private Country country;

    public City() {
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

    