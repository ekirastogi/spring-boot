package com.ekiras.domain;

import com.ekiras.domain.embeddable.Address;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ekansh
 * @since 22/7/16
 */
@Entity(name = "user")
@Table(name = "user", schema = "main")
public class User {

    @Id
    private long id;
    private String name;
    private String email;
    @Embedded
    private Address address;


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
}
