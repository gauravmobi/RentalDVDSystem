package com.mobiquity.rentaldvdstore.pojo;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address extends MetadataPojo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;
    private String address;
    private String district;
    @OneToOne
    private City city;
    private int postalCode;
    private String location;

    public Address() {
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", city=" + city +
                ", postalCode=" + postalCode +
                ", location='" + location + '\'' +
                '}';
    }
}
