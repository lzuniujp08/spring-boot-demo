package com.lzugis.entity;

import lombok.Data;

@Data
public class City {
    private String name;
    private Double lon;
    private Double lat;
    private String wkt;
}
