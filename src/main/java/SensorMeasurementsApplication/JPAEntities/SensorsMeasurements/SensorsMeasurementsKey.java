package SensorMeasurementsApplication.JPAEntities.SensorsMeasurements;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class SensorsMeasurementsKey {
    @Column(name = "sensor_id") private Integer sensorId;

    @Column(name = "type_id") private Integer typeId;

    public SensorsMeasurementsKey(Integer sensorId, Integer typeId) {
        this.sensorId = sensorId;
        this.typeId = typeId;
    }

    public SensorsMeasurementsKey(){}

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}