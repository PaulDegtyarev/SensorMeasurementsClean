package SensorMeasurementsApplication.Factories.MeasurementsTypes;

import SensorMeasurementsApplication.CustomModels.MeasurementsTypes.MeasurementsType;
import SensorMeasurementsApplication.RequestBodies.MeasurementsTypes.MeasurementsTypesRequestBody;

public interface MeasurementsTypeFactory {
    MeasurementsType create(MeasurementsTypesRequestBody data);
}
