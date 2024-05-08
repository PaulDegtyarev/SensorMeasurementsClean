package SensorMeasurementsApplication.RequestBodies.Sensors.Put;

public class SensorsRequestModelPut {
    private String sensor_name;

    public SensorsRequestModelPut(String sensor_name) {
        this.sensor_name = sensor_name;
    }
    public SensorsRequestModelPut(){}

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }
}
