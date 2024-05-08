package SensorMeasurementsApplication.DataStores.Sensors;

import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import SensorMeasurementsApplication.RequestDataStoreModels.Sensors.SensorsRequestDSModel;
import SensorMeasurementsApplication.ResponseDataStoreModels.Sensors.SensorsDSResponsePost;

import java.util.List;

public interface SensorsDS {
    SensorsDSResponsePost save(SensorsRequestDSModel data);

    void delete(Integer sensorId);

    void update(Integer sensorId, String sensorName);

    List<SensorsEntity> all();

    SensorsDSResponsePost one(Integer sensorId);

    boolean existsByTypeId(Integer typeId);

    boolean existsBySensorName(String sensorName);

    boolean hasMeasurements(Integer sensorId);

    boolean existsBySensorId(Integer sensorId);
}
