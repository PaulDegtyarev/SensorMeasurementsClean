package SensorMeasurementsApplication.RequestDataStoreModels.Meteostations;

public class MeteostationsDSRequestModel {
    private String stationName;
    private Double stationLongitude;
    private Double stationLatitude;
    private String stationCountry;

    public MeteostationsDSRequestModel(String stationName, Double stationLongitude, Double stationLatitude, String stationCountry) {
        this.stationName = stationName;
        this.stationLongitude = stationLongitude;
        this.stationLatitude = stationLatitude;
        this.stationCountry = stationCountry;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Double getStationLongitude() {
        return stationLongitude;
    }

    public void setStationLongitude(Double stationLongitude) {
        this.stationLongitude = stationLongitude;
    }

    public Double getStationLatitude() {
        return stationLatitude;
    }

    public void setStationLatitude(Double stationLatitude) {
        this.stationLatitude = stationLatitude;
    }

    public String getStationCountry() {
        return stationCountry;
    }

    public void setStationCountry(String stationCountry) {
        this.stationCountry = stationCountry;
    }
}
