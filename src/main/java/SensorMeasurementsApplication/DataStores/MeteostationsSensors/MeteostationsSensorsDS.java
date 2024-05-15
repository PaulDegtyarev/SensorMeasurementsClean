package SensorMeasurementsApplication.DataStores.MeteostationsSensors;

import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModel;

import java.util.List;

public interface MeteostationsSensorsDS {
    List<MeteostationsSensorsEntity> create(MeteostationsSensorsDSRequestModel dsRequest);

    boolean existsByStationIdAndSensorId(Integer stationId, Integer sensorId);
}
