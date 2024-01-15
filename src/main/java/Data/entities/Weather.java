package Data.entities;

import com.opencsv.bean.CsvBindByName;

public class Weather {
    @CsvBindByName(column = "Day")
    public int day;
    @CsvBindByName(column = "MxT")
    public int mxt;
    @CsvBindByName(column = "MnT")
    public int mnt;
    @CsvBindByName(column = "AvT")
    public int avt;
    @CsvBindByName(column = "AvDP")
    public float avdp;
    @CsvBindByName(column = "1HrP")
    public int hrp;
    @CsvBindByName(column = "TPcpn")
    public int tpcpn;
    @CsvBindByName(column = "PDir")
    public int pdir;
    @CsvBindByName(column = "AvSp")
    public float avsp;
    @CsvBindByName(column = "Dir")
    public int dir;
    @CsvBindByName(column = "MxS")
    public int mxs;
    @CsvBindByName(column = "SkyC")
    public float skyc;
    @CsvBindByName(column = "MxR")
    public int mxr;
    @CsvBindByName(column = "Mn")
    public int mn;
    @CsvBindByName(column = "R AvSLP")
    public float ravslp;

    // *Erinnerung für unser Gespräch* 
    // Repository Pattern -> auslagern in WeatherReadModel Klasse
    public int tempDif;
}