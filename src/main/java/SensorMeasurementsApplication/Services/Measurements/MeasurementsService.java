package SensorMeasurementsApplication.Services.Measurements;

import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBodyList;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;

public interface MeasurementsService {

    MeasurementsPostResponseModel create(MeasurementsRequestBodyList data);

    MeasurementsPostResponseModel byParam(Integer sensorInventoryNumber);

    MeasurementsPostResponseModel all();
}
