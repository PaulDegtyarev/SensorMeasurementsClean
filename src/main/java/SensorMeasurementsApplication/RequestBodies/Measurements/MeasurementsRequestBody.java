package SensorMeasurementsApplication.RequestBodies.Measurements;

public class MeasurementsRequestBody {
    private Float measurement_value;
    private Integer measurement_type;
    private String measurement_ts;
    private Integer sensor_inventory_number;

    public MeasurementsRequestBody(Float measurement_value, Integer measurement_type, String measurement_ts, Integer sensor_inventory_number) {
        this.measurement_value = measurement_value;
        this.measurement_type = measurement_type;
        this.measurement_ts = measurement_ts;
        this.sensor_inventory_number = sensor_inventory_number;
    }

    public Float getMeasurement_value() {
        return measurement_value;
    }

    public void setMeasurement_value(Float measurement_value) {
        this.measurement_value = measurement_value;
    }

    public Integer getMeasurement_type() {
        return measurement_type;
    }

    public void setMeasurement_type(Integer measurement_type) {
        this.measurement_type = measurement_type;
    }

    public String getMeasurement_ts() {
        return measurement_ts;
    }

    public void setMeasurement_ts(String measurement_ts) {
        this.measurement_ts = measurement_ts;
    }

    public Integer getSensor_inventory_number() {
        return sensor_inventory_number;
    }

    public void setSensor_inventory_number(Integer sensor_inventory_number) {
        this.sensor_inventory_number = sensor_inventory_number;
    }
}
