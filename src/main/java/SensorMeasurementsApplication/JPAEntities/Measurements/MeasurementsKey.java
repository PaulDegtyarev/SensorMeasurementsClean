package SensorMeasurementsApplication.JPAEntities.Measurements;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MeasurementsKey {
    @Column(name = "measurement_value") private Float measurementValue;
    @Column(name = "measurement_type") private Integer measurementType;
    @Column(name = "measurement_ts") private String measurementTS;
    @Column(name = "sensor_inventory_number") private Integer sensorInventoryNumber;

    public MeasurementsKey(Float measurementValue, Integer measurementType, String measurementTS, Integer sensorInventoryNumber) {
        this.measurementValue = measurementValue;
        this.measurementType = measurementType;
        this.measurementTS = measurementTS;
        this.sensorInventoryNumber = sensorInventoryNumber;
    }

    public MeasurementsKey(){}

    public Float getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(Float measurementValue) {
        this.measurementValue = measurementValue;
    }

    public Integer getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(Integer measurementType) {
        this.measurementType = measurementType;
    }

    public String getMeasurementTS() {
        return measurementTS;
    }

    public void setMeasurementTS(String measurementTS) {
        this.measurementTS = measurementTS;
    }

    public Integer getSensorInventoryNumber() {
        return sensorInventoryNumber;
    }

    public void setSensorInventoryNumber(Integer sensorInventoryNumber) {
        this.sensorInventoryNumber = sensorInventoryNumber;
    }
}
