package SensorMeasurementsApplication.Responses.MeteostationsSensors.Get;

import java.util.List;

public class MeteostationsSensorsMeteostationInfo {
    private Integer station_id;
    private String station_name;
    private Double station_longitude;
    private Double station_latitude;
    private List<MeteostationsSensorsSensorsList> sensors;

    public MeteostationsSensorsMeteostationInfo(Integer station_id, String station_name, Double station_longitude, Double station_latitude, List<MeteostationsSensorsSensorsList> sensors) {
        this.station_id = station_id;
        this.station_name = station_name;
        this.station_longitude = station_longitude;
        this.station_latitude = station_latitude;
        this.sensors = sensors;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
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

    public List<MeteostationsSensorsSensorsList> getSensors() {
        return sensors;
    }

    public void setSensors(List<MeteostationsSensorsSensorsList> sensors) {
        this.sensors = sensors;
    }
}
