package com.example.demo.forms;

public class RealtyForm {
    private String street;
    private Integer houseNumber;


    public Integer getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() { return street; }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
}
