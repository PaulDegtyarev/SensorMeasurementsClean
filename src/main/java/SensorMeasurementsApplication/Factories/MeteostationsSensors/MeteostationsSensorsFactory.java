package SensorMeasurementsApplication.Factories.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.MeteostationsSensorsRequestBody;

import java.util.List;

public interface MeteostationsSensorsFactory {
    List<MeteostationsSensors> create(MeteostationsSensorsRequestBody data);
}
