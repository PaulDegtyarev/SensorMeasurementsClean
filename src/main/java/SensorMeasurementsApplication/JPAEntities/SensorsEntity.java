package SensorMeasurementsApplication.JPAEntities;

import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sensors", schema = "public")
public class SensorsEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "sensor_id") private Integer sensorId;
    @Column(name = "sensor_name", nullable = false)  private String sensorName;

    public SensorsEntity(String sensorName){
        this.sensorName = sensorName;
    }

    public SensorsEntity(){}

    @OneToMany(mappedBy = "sensor")
    private List<SensorsMeasurementsEntity> sensorsMeasurements;

    @OneToMany(mappedBy = "sensor")
    private Set<MeteostationsSensorsEntity> meteostationsSensors;

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public List<SensorsMeasurementsEntity> getSensorsMeasurements() {
        return sensorsMeasurements;
    }

    public void setSensorsMeasurements(List<SensorsMeasurementsEntity> sensorsMeasurements) {
        this.sensorsMeasurements = sensorsMeasurements;
    }

    public Set<MeteostationsSensorsEntity> getMeteostationsSensors() {
        return meteostationsSensors;
    }

    public void setMeteostationsSensors(Set<MeteostationsSensorsEntity> meteostationsSensors) {
        this.meteostationsSensors = meteostationsSensors;
    }
}

