package SensorMeasurementsApplication.Services.Sensors;

import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsPostRequestBody;
import SensorMeasurementsApplication.Responses.Sensors.GetAll.SensorsResponseModelGetAll;
import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsResponseModelPost;

import java.util.List;

public interface SensorsService {
    SensorsResponseModelPost create(SensorsPostRequestBody data);

    void delete(Integer sensorId);

    void update(Integer sensorId, String sensorName);

    SensorsResponseModelGetAll all();

    SensorsResponseModelPost one(Integer sensorId);
}
