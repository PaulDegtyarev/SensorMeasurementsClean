package SensorMeasurementsApplication.DataStores.MeteostationsSensors;

import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModel;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModelForDelete;

import java.util.List;

public interface MeteostationsSensorsDS {
    List<MeteostationsSensorsEntity> create(MeteostationsSensorsDSRequestModel dsRequest);

    void delete(MeteostationsSensorsDSRequestModelForDelete dsRequest);

    List<MeteostationsSensorsEntity> get();

    boolean existsByStationIdAndSensorId(Integer stationId, Integer sensorId);

    boolean existsBySensorInventoryNumber(Integer sensorInventoryNumber);

    boolean existsByStationId(Integer stationId);

    boolean existsBySensorId(Integer sensorId);

    MeteostationsEntity one(Integer stationId);
}
