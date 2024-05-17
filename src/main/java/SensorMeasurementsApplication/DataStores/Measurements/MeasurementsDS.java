package SensorMeasurementsApplication.DataStores.Measurements;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;

import java.util.List;

public interface MeasurementsDS {

    List<MeasurementsEntity> create(MeasurementsDSRequesModel dsRequest);

    List<MeasurementsEntity> getByParam(Integer sensorInventoryNumber);

    List<MeasurementsEntity> all();

    boolean existsByTypeId(Integer typeId);

    boolean existsBySensorInventoryNumber(Integer sensorInventoryNumber);

    boolean existsByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber);
}
