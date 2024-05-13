package SensorMeasurementsApplication.JPAEntities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "meteostations", schema = "public")
public class MeteostationsEntity {
    @Column(name = "station_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer stationId;
    @Column(name = "station_name") private String stationName;
    @Column(name = "station_longitude") private Double stationLongitude;
    @Column(name = "station_latitude") private Double stationLatitude;
    @Column(name = "station_country") private String stationCountry;

    @OneToMany(mappedBy = "meteostation", cascade = CascadeType.ALL)
    private List<MeteostationsSensorsEntity> meteostationsSensors;


    public MeteostationsEntity(String stationName, Double stationLongitude, Double stationLatitude, String stationCountry) {
        this.stationName = stationName;
        this.stationLongitude = stationLongitude;
        this.stationLatitude = stationLatitude;
        this.stationCountry = stationCountry;
    }

    public MeteostationsEntity(){}

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
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

    public List<MeteostationsSensorsEntity> getMeteostationsSensors() {
        return meteostationsSensors;
    }

    public void setMeteostationsSensors(List<MeteostationsSensorsEntity> meteostationsSensors) {
        this.meteostationsSensors = meteostationsSensors;
    }
}
