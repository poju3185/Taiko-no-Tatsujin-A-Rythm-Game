package edu.uchicago.gerber._03objects.P8_14;

import lombok.Getter;

@Getter
public class Country {
    private final String name;
    private final int population;
    private final double area;
    private final double populationDensity;

    public Country(String name, int population, int area){
        this.name = name;
        this.population = population;
        this.area = area;
        this.populationDensity = (double) population / area;
    }
}
