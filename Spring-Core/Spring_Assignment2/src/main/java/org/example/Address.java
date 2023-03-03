package org.example;

import org.springframework.stereotype.Component;

@Component
public class Address {
    private String city;
    private String state; // or province, county, territory....
    private String street;
    private String zipcode;

    public Address(String city, String state, String street, String zipcode) {
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", street='" + street + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
