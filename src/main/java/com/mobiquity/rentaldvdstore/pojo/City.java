package com.mobiquity.rentaldvdstore.pojo;

import javax.persistence.*;

@Entity
@Table(name = "City")
public class City extends MetadataPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int city_id;
    private String city;
    @ManyToOne
    private Country country_id;

    public City() {
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Country country_id) {
        this.country_id = country_id;
    }
}
