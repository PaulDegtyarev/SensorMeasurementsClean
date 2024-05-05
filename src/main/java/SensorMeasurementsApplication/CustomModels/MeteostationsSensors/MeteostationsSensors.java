package SensorMeasurementsApplication.CustomModels.MeteostationsSensors;

import java.sql.Timestamp;
import java.time.Instant;

public interface MeteostationsSensors {

    Integer getSensorInventoryNumber();

    Integer getStationId();

    Integer getSensorId();

    Instant getAddedTS();

    Timestamp getRemovedTS();
}
