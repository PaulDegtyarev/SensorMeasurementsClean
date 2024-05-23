package SensorMeasurementsApplication.DataStores.SensorsMeasurements;

import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Delete.SensorsMeasurementsRequestBodyDelete;
import SensorMeasurementsApplication.RequestDataStoreModels.SensorsMeasurements.SensorsMeasurementsDSRequestModel;

import java.util.List;

public interface SensorsMeasurementsDS {
    List<SensorsMeasurementsEntity> create(SensorsMeasurementsDSRequestModel dsRequest);

    void delete(Integer sensorId, SensorsMeasurementsRequestBodyDelete measurementsType);

    boolean existsBySensorId(Integer sensorId);

    boolean existsByTypeId(Integer typeId);
}
