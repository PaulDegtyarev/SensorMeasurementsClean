package SensorMeasurementsApplication.CustomModels.Meteostations;

public class MeteostationImpl implements Meteostation{
    private String stationName;
    private Double stationLongitude;
    private Double stationLatitude;
    private String stationCountry;

    public MeteostationImpl(String stationName, Double stationLongitude, Double stationLatitude, String stationCountry) {
        this.stationName = stationName;
        this.stationLongitude = stationLongitude;
        this.stationLatitude = stationLatitude;
        this.stationCountry = stationCountry;
    }

    @Override
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public Double getStationLongitude() {
        return stationLongitude;
    }

    public void setStationLongitude(Double stationLongitude) {
        this.stationLongitude = stationLongitude;
    }

    @Override
    public Double getStationLatitude() {
        return stationLatitude;
    }

    public void setStationLatitude(Double stationLatitude) {
        this.stationLatitude = stationLatitude;
    }

    @Override
    public String getStationCountry() {
        return stationCountry;
    }

    public void setStationCountry(String stationCountry) {
        this.stationCountry = stationCountry;
    }
}
