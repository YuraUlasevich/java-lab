package com.ulasevich.scooters.domain;

import javax.persistence.*;

@Entity
public class Scooters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private Boolean flag;
    private String producer;
    private String brand;
    private Integer charge_level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getChargeLevel() {
        return charge_level;
    }

    public void setChargeLevel(Integer charge_level) {
        this.charge_level = charge_level;
    }

    public Scooters() {
    }

    public Scooters(String location, Boolean flag, String producer, String brand, Integer charge_level) {
        this.location = location;
        this.flag = flag;
        this.producer = producer;
        this.brand = brand;
        this.charge_level = charge_level;
    }
}
