package com.ulasevich.scooters.models;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Scooter {
    private Integer id;

    @Size(min=2, max=10)
    private String location;
    private Boolean flag;

    @Size(min=2, max=10)
    private String producer;

    @Size(min=2, max=10)
    private String brand;

    @Digits(integer = 3, fraction = 0)
    @Max(100)
    @Min(0)
    private Integer charge_level;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getCharge_level() {
        return charge_level;
    }

    public void setCharge_level(Integer charge_level) {
        this.charge_level = charge_level;
    }

    public Scooter(Integer id, String location, Boolean flag, String producer, String brand, Integer charge_level) {
        this.id = id;
        this.location = location;
        this.flag = flag;
        this.producer = producer;
        this.brand = brand;
        this.charge_level = charge_level;
    }

    public Scooter() {
    }
}
