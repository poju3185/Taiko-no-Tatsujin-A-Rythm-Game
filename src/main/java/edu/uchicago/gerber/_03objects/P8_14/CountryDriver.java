package edu.uchicago.gerber._03objects.P8_14;

public class CountryDriver {
    public static void main(String[] args) {
        Country[] countries = new Country[4];
        countries[0] = new Country("China", 1425, 3700);
        countries[1] = new Country("US", 331, 9372);
        countries[2] = new Country("India", 1428, 3287);
        countries[3] = new Country("Russia", 140, 17098);

        Country largestAreaCountry = countries[0];
        Country largetPopulationCountry = countries[0];
        Country largetPopulationDensityCountry = countries[0];

        for (Country country : countries) {
            if (country.getArea() > largestAreaCountry.getArea()) {
                largestAreaCountry = country;
            }
            if (country.getPopulation() > largetPopulationCountry.getPopulation()) {
                largetPopulationCountry = country;
            }
            if (country.getPopulationDensity() > largetPopulationDensityCountry.getPopulation()) {
                largetPopulationDensityCountry = country;
            }
        }
        System.out.println("largest area: " + largestAreaCountry.getName());
        System.out.println("largest population: " + largetPopulationCountry.getName());
        System.out.println("largest population density: " + largetPopulationDensityCountry.getName());
    }
}
