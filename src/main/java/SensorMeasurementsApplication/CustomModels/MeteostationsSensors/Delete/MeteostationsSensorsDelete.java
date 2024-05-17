package SensorMeasurementsApplication.CustomModels.MeteostationsSensors.Delete;

import org.hibernate.context.TenantIdentifierMismatchException;

import java.sql.Timestamp;
import java.time.Instant;

public interface MeteostationsSensorsDelete {
    Integer getSensorInventoryNumber();

    Timestamp getRemovedTS();
}
