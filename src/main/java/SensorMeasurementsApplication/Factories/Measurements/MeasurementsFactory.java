package SensorMeasurementsApplication.Factories.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;

public interface MeasurementsFactory {
    Measurements create(MeasurementsRequestBody data);
}
