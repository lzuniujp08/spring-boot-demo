package com.lzugis.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.lzugis.entity.City;

public class TxtUtil {

    public List<City> getFileContent(File file) {
        String line = "";
        String everyLine = "";
        List<City> cities = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int row = 0;
            while ((line = br.readLine()) != null) {
                if (row > 0) {
                    line = line.replaceAll("\"", "");
                    String[] lineData = line.split(",");
                    City city = new City(
                        Integer.parseInt(lineData[1]),
                        lineData[0],
                        Double.parseDouble(lineData[2]),
                        Double.parseDouble(lineData[3]),
                        ""
                    );
                    cities.add(city);
                }
                row++;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void main(String[] args) {
        String fileName = "capital.csv";
        String[] fileInfo = fileName.split("\\.");
        System.out.println(fileInfo);
    }
}
