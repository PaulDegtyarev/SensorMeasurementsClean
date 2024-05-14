package SensorMeasurementsApplication.DataStores.MeasurementsTypes;

import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.RequestBodies.MeasurementsTypes.MeasurementsTypesRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.MeasurementsTypes.MeasurementsTypeDSRequestModel;

import java.util.List;

public interface MeasurementsTypeDS {
    MeasurementsTypeEntity create(MeasurementsTypeDSRequestModel data);

    void delete(Integer typeId);

    void update(Integer typeId, MeasurementsTypesRequestBody data);

    List<MeasurementsTypeEntity> getAll();

    boolean hasMeasurements(Integer typeId);

    boolean existsByTypeName(String typeName);

    boolean existsByTypeId(Integer typeId);
}
