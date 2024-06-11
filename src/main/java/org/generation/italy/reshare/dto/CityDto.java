package org.generation.italy.reshare.dto;

import org.generation.italy.reshare.model.City;

public class CityDto {
    private int id;
    private String name;
    private String lockerpoint;


    public CityDto() {
    }

    public CityDto(City city) {
        this.id = city.getId();
        this.name = city.getName();
        this.lockerpoint = city.getLockerpoint();
    }

    public City toCity(){
        return new City(this.name, this.lockerpoint);
    }
}