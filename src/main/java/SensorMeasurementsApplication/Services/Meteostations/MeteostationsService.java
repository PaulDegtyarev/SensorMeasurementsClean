package SensorMeasurementsApplication.Services.Meteostations;

import SensorMeasurementsApplication.RequestBodies.Meteostations.MeteostationRequestBody;
import SensorMeasurementsApplication.Responses.Meteostations.MeteostationResponseModel;
import SensorMeasurementsApplication.Responses.Meteostations.WithSensors.MeteostationsWithSensorsReponseModel;

import java.util.List;

public interface MeteostationsService {
    MeteostationResponseModel create(MeteostationRequestBody data);

    void delete(Integer stationId);

    void update(Integer stationId, MeteostationRequestBody data);

    List<MeteostationResponseModel> all();

    MeteostationResponseModel one(Integer stationId);

    List<MeteostationResponseModel> byParam(String stationName, Double stationLongitude, Double stationLatitude, String stationCountry);

    MeteostationsWithSensorsReponseModel withSensors(Integer stationId);
}
