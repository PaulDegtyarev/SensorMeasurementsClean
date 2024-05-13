package SensorMeasurementsApplication.RequestBodies.Meteostations;

public class MeteostationRequestBody {
    private String station_name;
    private Double station_longitude;
    private Double station_latitude;
    private String station_country;

    public MeteostationRequestBody(String station_name, Double station_longitude, Double station_latitude, String station_country) {
        this.station_name = station_name;
        this.station_longitude = station_longitude;
        this.station_latitude = station_latitude;
        this.station_country = station_country;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public Double getStation_longitude() {
        return station_longitude;
    }

    public void setStation_longitude(Double station_longitude) {
        this.station_longitude = station_longitude;
    }

    public Double getStation_latitude() {
        return station_latitude;
    }

    public void setStation_latitude(Double station_latitude) {
        this.station_latitude = station_latitude;
    }

    public String getStation_country() {
        return station_country;
    }

    public void setStation_country(String station_country) {
        this.station_country = station_country;
    }
}
