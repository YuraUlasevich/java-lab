package com.example.demo.model;

public class Realty {
    private String street;
    private Integer houseNumber;

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Realty(String street, Integer houseNumber){
        this.street = street;
        this.houseNumber = houseNumber;
    }

}
