package SensorMeasurementsApplication.Factories.Sensors;

import SensorMeasurementsApplication.CustomModels.Sensors.Sensor;
import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsMeasurementsRequestBodyList;
import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsPostRequestBody;

import java.util.List;

public interface SensorsFactory {
    Sensor create(SensorsPostRequestBody data);
}
