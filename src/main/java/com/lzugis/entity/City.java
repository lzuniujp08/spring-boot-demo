package com.lzugis.entity;

import lombok.Data;

@Data
public class City {

    public City(Integer id, String name, Double lon, double lat, String wkt) {
        this.id = id;
        this.name = name;
        this.lon = lon;
        this.lat = lat;
        this.wkt = wkt;
    }

    private Integer id;
    private String name;
    private Double lon;
    private Double lat;
    private String wkt;
}
