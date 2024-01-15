package Data.entities;

import java.math.BigDecimal;

import com.opencsv.bean.CsvBindByName;

public class Country {
    @CsvBindByName(column = "Name")
    public String name;
    @CsvBindByName(column = "Capital")
    public String capital;
    @CsvBindByName(column = "Accession")
    public String accession;
    @CsvBindByName(column = "Population")
    public String population;
    @CsvBindByName(column = "Area (kmÂ²)")
    public BigDecimal area;
    @CsvBindByName(column = "GDP (US$ M)")
    public BigDecimal gdp;
    @CsvBindByName(column = "HDI")
    public BigDecimal hdi;
    @CsvBindByName(column = "MEPs")
    public BigDecimal mep;

    // *Erinnerung für unser Gespräch* 
    // Repository Pattern -> auslagern in CountryReadModel Klasse
    public BigDecimal popDensity;
}

