package SensorMeasurementsApplication.JPAEntities;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "meteostations_sensors", schema = "public")
public class MeteostationsSensorsEntity {
    @Column(name = "sensor_inventory_number") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer sensorInventoryNumber;
    @Column(name = "station_id") private Integer stationId;
    @Column(name = "sensor_id") private Integer sensorId;
    @Column(name = "added_ts") private Instant addedTS;
    @Column(name = "removed_ts", columnDefinition = "TIMESTAMP DEFAULT '9999-01-01 00:00:00'") private Timestamp removedTS = Timestamp.valueOf("9999-01-01 00:00:00");

    @ManyToOne
    @JoinColumn(name = "sensor_id", insertable=false, updatable=false)
    private SensorsEntity sensor;

    @ManyToOne
    @JoinColumn(name = "station_id", insertable=false, updatable=false)
    private MeteostationsEntity meteostation;

    @OneToMany(mappedBy = "meteostationsSensors")
    private Set<MeasurementsEntity> measurement;


    public MeteostationsSensorsEntity(Integer stationId, Integer sensorId, Instant addedTS) {
        this.stationId = stationId;
        this.sensorId = sensorId;
        this.addedTS = addedTS;
    }

    public MeteostationsSensorsEntity(){}

    public Integer getSensorInventoryNumber() {
        return sensorInventoryNumber;
    }

    public void setSensorInventoryNumber(Integer sensorInventoryNumber) {
        this.sensorInventoryNumber = sensorInventoryNumber;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Instant getAddedTS() {
        return addedTS;
    }

    public void setAddedTS(Instant addedTS) {
        this.addedTS = addedTS;
    }

    public Timestamp getRemovedTS() {
        return removedTS;
    }

    public void setRemovedTS(Timestamp removedTS) {
        this.removedTS = removedTS;
    }

    public SensorsEntity getSensor() {
        return sensor;
    }

    public void setSensor(SensorsEntity sensor) {
        this.sensor = sensor;
    }

    public MeteostationsEntity getMeteostation() {
        return meteostation;
    }

    public void setMeteostation(MeteostationsEntity meteostation) {
        this.meteostation = meteostation;
    }

    public Set<MeasurementsEntity> getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Set<MeasurementsEntity> measurement) {
        this.measurement = measurement;
    }
}
