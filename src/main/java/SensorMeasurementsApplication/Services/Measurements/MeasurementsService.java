package SensorMeasurementsApplication.Services.Measurements;

import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBodyList;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;

import java.util.Optional;

public interface MeasurementsService {

    MeasurementsPostResponseModel create(MeasurementsRequestBodyList data);

    MeasurementsPostResponseModel byParam(Integer sensorInventoryNumber);

    MeasurementsPostResponseModel all();

    void deleteByTime(String from, String to);

    void deleteByStationId(Integer stationId);

    void deleteBySensorId(Integer sensorId);
}
