package SensorMeasurementsApplication.CustomModels.Measurements;

import java.sql.Timestamp;

public class MeasurementsImpl implements Measurements{
    private Float measurementsValue;
    private Timestamp measurementTS;
    private Integer sensorInventoryNumber;
    private Integer measurementType;

    public MeasurementsImpl(Float measurementsValue, Timestamp measurementTS, Integer sensorInventoryNumber, Integer measurementType) {
        this.measurementsValue = measurementsValue;
        this.measurementTS = measurementTS;
        this.sensorInventoryNumber = sensorInventoryNumber;
        this.measurementType = measurementType;
    }

    @Override
    public Float getMeasurementsValue() {
        return measurementsValue;
    }

    public void setMeasurementsValue(Float measurementsValue) {
        this.measurementsValue = measurementsValue;
    }

    @Override
    public Timestamp getMeasurementTS() {
        return measurementTS;
    }

    public void setMeasurementTS(Timestamp measurementTS) {
        this.measurementTS = measurementTS;
    }

    @Override
    public Integer getSensorInventoryNumber() {
        return sensorInventoryNumber;
    }

    public void setSensorInventoryNumber(Integer sensorInventoryNumber) {
        this.sensorInventoryNumber = sensorInventoryNumber;
    }

    @Override
    public Integer getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(Integer measurementType) {
        this.measurementType = measurementType;
    }
}
