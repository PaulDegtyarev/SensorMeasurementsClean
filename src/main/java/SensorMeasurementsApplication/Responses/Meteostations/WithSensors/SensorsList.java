package SensorMeasurementsApplication.Responses.Meteostations.WithSensors;

public class SensorsList {
    private Integer sensor_id;
    private String sensor_name;

    public SensorsList(Integer sensor_id, String sensor_name) {
        this.sensor_id = sensor_id;
        this.sensor_name = sensor_name;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }
}
