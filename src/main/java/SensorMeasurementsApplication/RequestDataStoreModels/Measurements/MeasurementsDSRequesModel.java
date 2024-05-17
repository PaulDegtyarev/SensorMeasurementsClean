package SensorMeasurementsApplication.RequestDataStoreModels.Measurements;

public class MeasurementsDSRequesModel {
    private Float measurementsValue;
    private String measurementTS;
    private Integer sensorInventoryNumber;
    private Integer measurementType;

    public MeasurementsDSRequesModel(Float measurementsValue, String measurementTS, Integer sensorInventoryNumber, Integer measurementType) {
        this.measurementsValue = measurementsValue;
        this.measurementTS = measurementTS;
        this.sensorInventoryNumber = sensorInventoryNumber;
        this.measurementType = measurementType;
    }

    public Float getMeasurementsValue() {
        return measurementsValue;
    }

    public void setMeasurementsValue(Float measurementsValue) {
        this.measurementsValue = measurementsValue;
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

    public Integer getMeasurementType() {
        return measurementType;
    }

    public void setMeasurementType(Integer measurementType) {
        this.measurementType = measurementType;
    }
}
