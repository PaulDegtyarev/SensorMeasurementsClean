package SensorMeasurementsApplication.DataStores.Measurements;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequestModelDelete;

import java.util.List;

public interface MeasurementsDS {

    List<MeasurementsEntity> create(MeasurementsDSRequesModel dsRequest);

    List<MeasurementsEntity> getByParam(Integer sensorInventoryNumber);

    List<MeasurementsEntity> all();


    void deleteByTime(MeasurementsDSRequestModelDelete dsRequest);

    void deleteByStationId(Integer stationId);

    void deleteBySensorId(Integer sensorId);

    boolean existsByTypeId(Integer typeId);

    boolean existsBySensorInventoryNumber(Integer sensorInventoryNumber);

    boolean existsByStationId(Integer stationId);

    boolean existsByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber);

    boolean existsBySensorId(Integer sensorId);
}
