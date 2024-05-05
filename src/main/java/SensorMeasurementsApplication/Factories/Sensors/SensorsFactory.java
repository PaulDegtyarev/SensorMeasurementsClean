package SensorMeasurementsApplication.Factories.Sensors;

import SensorMeasurementsApplication.CustomModels.Sensors.Sensor;

public interface SensorsFactory {
    Sensor create(String sensorName);
}
