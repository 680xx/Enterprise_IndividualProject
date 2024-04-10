package com.example.enterprise_individualproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Attributes
    @Column(length = 60, nullable = false)
    private String street;
    @Column(length = 10, nullable = false)
    private int postalCode;
    @Column(length = 40, nullable = false)
    private String city;

    @JsonIgnoreProperties("address")
    @OneToMany(mappedBy = "address")
    private List<Member> members;


    // Constructors
    public Address() {
    }
    public Address(String street, int postalCode, String city, List<Member> members) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.members = members;
    }


    // Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public List<Member> getMembers() {
        return members;
    }
    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
