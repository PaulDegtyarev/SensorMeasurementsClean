package SensorMeasurementsApplication.CustomModels.Measurements;

import java.sql.Timestamp;

public interface Measurements {

    Float getMeasurementsValue();

    Timestamp getMeasurementTS();

    Integer getSensorInventoryNumber();

    Integer getMeasurementType();
}
