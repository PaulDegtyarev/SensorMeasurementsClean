package SensorMeasurementsApplication.Factories.SensorsMeasurements;

import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurements;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Post.SensorsMeasurementsRequesBody;

import java.util.List;

public interface SensorsMeasurementsFactory {
    List<SensorsMeasurements> create(Integer sensorId, SensorsMeasurementsRequesBody data);
}
