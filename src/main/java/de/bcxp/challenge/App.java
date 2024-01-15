package de.bcxp.challenge;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import Data.entities.Country;
import Data.entities.Weather;
import Enums.Entities;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {
    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     * @throws IOException
     * @throws FileNotFoundException
     * @throws CsvException
     * @throws CsvValidationException
     */
    public static void main(String... args) throws FileNotFoundException, IOException, CsvException {

        // *Erinnerung für unser Gespräch* 
        // filePath und Filename auslagern in Java equivalente zu C# appsettings (connectionstrings) - Clean Code violation
        String filePath = "src\\main\\resources\\de\\bcxp\\challenge\\";
        List<Country> countries = getEntities(filePath + "countries.csv",';',Entities.Country);
        List<Weather> weatherList = getEntities(filePath + "weather.csv",',',Entities.Weather);

        String dayWithSmallestTempSpread = String.valueOf(Collections.min(weatherList, Comparator.comparing(y -> y.tempDif)).day); // Your day analysis function call …

        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = Collections.max(countries, Comparator.comparing(x -> x.popDensity)).name; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }

    /**
     * @param <T>
     * @param fileName
     * @param seperator
     * @param myEntities
     * @return List<T>
     * @throws FileNotFoundException
     */
    // *Erinnerung für unser Gespräch* 
    // Repository Pattern benutzen für die Daten
    public static <T> List<T> getEntities(String fileName, char seperator, Entities myEntities) throws FileNotFoundException{

        switch (myEntities) {
            case Country:
                CsvToBean<Country> csvReaderCountry = new CsvToBeanBuilder(new BufferedReader(new FileReader(fileName)))
                .withType(Country.class)
                .withSeparator(seperator)
                .build();

                // *Erinnerung für unser Gespräch* 
                // .withMappingStrategy() auf Basis vom Repository Pattern
                // Attribut popDensity auf ein CountryReadModel Mappen und jenes weiter verwenden für Frontend
                List<Country> countries = csvReaderCountry.parse();
                for (Country country : countries) {
                    country.popDensity = calcPopDensity(country.population, country.area);
                }
                return (List<T>) countries;

            case Weather:

                CsvToBean<Weather> csvReaderWeather = new CsvToBeanBuilder(new BufferedReader(new FileReader(fileName)))
                .withType(Weather.class)
                .withSeparator(seperator)
                .build();

                // *Erinnerung für unser Gespräch* 
                // .withMappingStrategy() auf Basis vom Repository Pattern
                // Attribut tempDif auf ein WeatherReadModel Mappen und jenes weiter verwenden für Frontend
                List<Weather> weatherCollection = csvReaderWeather.parse();
                for (Weather weather : weatherCollection) {
                    weather.tempDif = calcDiff(weather.mxt, weather.mnt);
                }

                return (List<T>) weatherCollection;
            default:
                break;
        }
        return null;
    }

    /**
     * @param max
     * @param min
     * @return difference between max and min value
     */
    // *Erinnerung für unser Gespräch*
    // Nur der Weather Klasse zuordnen -> über automapper auf das ReadModel
    public static int calcDiff(int max, int min){
        return max - min;
    }

    /**
     * @param population
     * @param area
     * @return population density
     */
    // *Erinnerung für unser Gespräch* 
    // Nur der Country Klasse zuordnen -> über automapper auf das ReadModel
    public static BigDecimal calcPopDensity(String population, BigDecimal area){
        BigDecimal popDec = new BigDecimal(population.replaceAll(",0*$","").replace(".", ""));
        return popDec.divide(area,4, RoundingMode.HALF_UP);
    }
}
