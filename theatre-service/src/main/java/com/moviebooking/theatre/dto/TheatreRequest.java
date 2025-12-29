package com.moviebooking.theatre.dto;


public class TheatreRequest {

    private String name;
    private String city;
    private String address;
    private Integer totalScreens;

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Integer getTotalScreens() {
        return totalScreens;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTotalScreens(Integer totalScreens) {
        this.totalScreens = totalScreens;
    }
}

