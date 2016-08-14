package com.ekiras.domain.embeddable;

import javax.persistence.Embeddable;

/**
 * @author ekansh
 * @since 22/7/16
 */
@Embeddable
public class Address {

    private String address;
    private String city;
    private String country;

    public Address(){}
    public Address(String address,String city, String counrty){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
