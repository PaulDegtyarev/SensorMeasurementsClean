package SensorMeasurementsApplication.Services.MeteostationsSensors;

import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Delete.MeteostationsSensorsDeleteRequestBody;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Post.MeteostationsSensorsRequestBody;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Get.MeteostationsSensorsGetResponseModel;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MeteostationsSensorsPostResponse;

public interface MeteostationsSensorsService {
    MeteostationsSensorsPostResponse create(MeteostationsSensorsRequestBody data);

    void delete(Integer sensorInventoryNumber, MeteostationsSensorsDeleteRequestBody data);

    MeteostationsSensorsGetResponseModel get();
}
