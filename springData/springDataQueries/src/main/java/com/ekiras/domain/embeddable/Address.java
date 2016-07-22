package com.ekiras.domain.embeddable;

import javax.persistence.Embeddable;

/**
 * @author ekansh
 * @since 22/7/16
 */
@Embeddable
public class Address {

    private String address;
    private int pin;
    private String city;
    private String state;
    private String country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
