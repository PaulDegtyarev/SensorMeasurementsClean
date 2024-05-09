package SensorMeasurementsApplication.CustomModels.Sensors;

import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsMeasurementsRequestBodyList;

import java.util.List;

public interface Sensor {
    String getSensorName();

    List<SensorsMeasurementsRequestBodyList> getSensorsMeasurements();
}
