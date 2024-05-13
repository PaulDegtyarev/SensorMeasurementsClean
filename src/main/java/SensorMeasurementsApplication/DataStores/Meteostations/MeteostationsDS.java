package SensorMeasurementsApplication.DataStores.Meteostations;

import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.RequestBodies.Meteostations.MeteostationRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.Meteostations.MeteostationsDSRequestModel;

import java.util.List;

public interface MeteostationsDS {
    MeteostationsEntity create(MeteostationsDSRequestModel requestModel);

    void delete(Integer stationId);

    void update(Integer stationId, MeteostationRequestBody data);

    List<MeteostationsEntity> all();

    MeteostationsEntity one(Integer stationId);

    List<MeteostationsEntity> byParam(MeteostationsDSRequestModel dsRequest);

    boolean existsByStationNameOrStationLongitudeAndStationLatitude(String stationName,
                                                                    Double stationLongitude,
                                                                    Double stationLatitude);

    boolean existsByStationId(Integer stationId);

    boolean hasMeasurements(Integer stationId);
}
