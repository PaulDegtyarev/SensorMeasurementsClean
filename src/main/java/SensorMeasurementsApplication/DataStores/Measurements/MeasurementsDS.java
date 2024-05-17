package SensorMeasurementsApplication.DataStores.Measurements;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;

public interface MeasurementsDS {
    MeasurementsEntity create(MeasurementsDSRequesModel dsRequest);
}
