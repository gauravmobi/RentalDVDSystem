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
}
