package com.ekiras.domain;

import com.ekiras.domain.embeddable.Address;
import com.ekiras.domain.embeddable.Dates;

import javax.persistence.*;

/**
 * @author ekansh
 * @since 22/7/16
 */
@Entity(name = "user")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    @Embedded
    private Address address;

    @Embedded
    private Dates dates;

    public User(){

    }
    public User(String name,String email, Address address,Dates dates){
        this.name=name;
        this.email=email;
        this.address=address;
        this.dates=dates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}
