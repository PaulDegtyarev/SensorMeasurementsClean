package SensorMeasurementsApplication.DataStores.MeasurementsTypes;

import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.RequestDataStoreModels.MeasurementsTypes.MeasurementsTypeDSRequestModel;

public interface MeasurementsTypeDS {
    MeasurementsTypeEntity create(MeasurementsTypeDSRequestModel data);

    boolean existsByTypeName(String typeName);
}
