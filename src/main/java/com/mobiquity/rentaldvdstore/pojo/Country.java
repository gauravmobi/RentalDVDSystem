package com.mobiquity.rentaldvdstore.pojo;

public class Country extends MetadataPojo
{
    private int country_id;
    private String country;

    public Country(int country_id, String country) {
        this.country_id = country_id;
        this.country = country;
    }

    public Country() {
    }
}
