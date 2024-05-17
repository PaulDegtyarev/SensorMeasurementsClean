package SensorMeasurementsApplication.CustomModels.Measurements;

public class MeasurementsImpl implements Measurements{
    private Float measurementsValue;
    private String measurementTS;
    private Integer sensorInventoryNumber;
    private Integer measurementType;

    public MeasurementsImpl(Float measurementsValue, String measurementTS, Integer sensorInventoryNumber, Integer measurementType) {
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
    public String getMeasurementTS() {
        return measurementTS;
    }

    public void setMeasurementTS(String measurementTS) {
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
