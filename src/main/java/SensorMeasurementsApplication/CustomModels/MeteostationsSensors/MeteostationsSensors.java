package SensorMeasurementsApplication.CustomModels.MeteostationsSensors;

import java.sql.Timestamp;
import java.time.Instant;

public interface MeteostationsSensors {
    Integer getStationId();

    Integer getSensorId();

    Instant getAddedTS();

}
