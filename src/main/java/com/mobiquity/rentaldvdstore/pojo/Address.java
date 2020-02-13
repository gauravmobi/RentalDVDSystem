package com.mobiquity.rentaldvdstore.pojo;

public class Address extends MetadataPojo
{
    private int address_id;
    private String address;
    private String district;
    private City city_id;
    private int postal_code;
    private String location;

    public Address(int address_id, String address, String district, City city_id, int postal_code, String location) {
        this.address_id = address_id;
        this.address = address;
        this.district = district;
        this.city_id = city_id;
        this.postal_code = postal_code;
        this.location = location;
    }

    public Address() {
    }


}
