package SensorMeasurementsApplication.Services.Measurements;

import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;

public interface MeasurementsService {
    MeasurementsPostResponseModel create(MeasurementsRequestBody data);
}
