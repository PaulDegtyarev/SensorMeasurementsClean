package SensorMeasurementsApplication.Responses.Sensors.GetAll;

import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsResponseModelPost;

import java.util.List;

public class SensorsResponseModelGetAll {
    private List<SensorsResponseModelPost> sensors;

    public List<SensorsResponseModelPost> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorsResponseModelPost> sensors) {
        this.sensors = sensors;
    }

    public SensorsResponseModelGetAll(List<SensorsResponseModelPost> sensors) {
        this.sensors = sensors;
    }
}
