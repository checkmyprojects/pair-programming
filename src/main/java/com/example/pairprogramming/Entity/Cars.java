package com.example.pairprogramming.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cars")
public class Cars implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String manufacturer;

    private String img;

    private int year;

    private int seats;

    private int gasType;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getGasType() {
        return gasType;
    }

    public void setGasType(int gasType) {
        this.gasType = gasType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cars() {
    }

    public Cars(Long id, String name, String manufacturer, String img, int year, int seats, int gasType, String description) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.img = img;
        this.year = year;
        this.seats = seats;
        this.gasType = gasType;
        this.description = description;
    }

    public Cars(String name, String manufacturer, String img, int year, int seats, int gasType, String description) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.img = img;
        this.year = year;
        this.seats = seats;
        this.gasType = gasType;
        this.description = description;
    }
}
