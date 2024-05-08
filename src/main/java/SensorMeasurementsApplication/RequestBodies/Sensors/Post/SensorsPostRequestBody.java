package SensorMeasurementsApplication.RequestBodies.Sensors.Post;

import java.util.List;

public class SensorsPostRequestBody {
    private String sensor_name;
    private List<SensorsMeasurementsRequestBodyList> sensors_measurements;

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public List<SensorsMeasurementsRequestBodyList> getSensors_measurements() {
        return sensors_measurements;
    }

    public void setSensors_measurements(List<SensorsMeasurementsRequestBodyList> sensors_measurements) {
        this.sensors_measurements = sensors_measurements;
    }

    public SensorsPostRequestBody(String sensor_name, List<SensorsMeasurementsRequestBodyList> sensors_measurements) {
        this.sensor_name = sensor_name;
        this.sensors_measurements = sensors_measurements;
    }
}
