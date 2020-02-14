package com.mobiquity.rentaldvdstore.pojo;

public class City extends MetadataPojo
{
    private int city_id;
    private String city;
    private Country country_id;

    public City() {
    }

    public City(int city_id, String city, Country country_id) {
        this.city_id = city_id;
        this.city = city;
        this.country_id = country_id;
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
