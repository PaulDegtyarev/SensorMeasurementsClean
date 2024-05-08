package SensorMeasurementsApplication.Responses.Sensors.Post;

import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurements;

import java.util.List;

public class SensorsResponseModelPost {
    private Integer sensor_id;
    private String sensor_name;
    private List<SensorsMeasurementsResponseModelPostList> sensors_measurements;

    public SensorsResponseModelPost(Integer sensor_id, String sensor_name, List<SensorsMeasurementsResponseModelPostList> sensors_measurements) {
        this.sensor_id = sensor_id;
        this.sensor_name = sensor_name;
        this.sensors_measurements = sensors_measurements;
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

    public List<SensorsMeasurementsResponseModelPostList> getSensors_measurements() {
        return sensors_measurements;
    }

    public void setSensors_measurements(List<SensorsMeasurementsResponseModelPostList> sensors_measurements) {
        this.sensors_measurements = sensors_measurements;
    }


}

