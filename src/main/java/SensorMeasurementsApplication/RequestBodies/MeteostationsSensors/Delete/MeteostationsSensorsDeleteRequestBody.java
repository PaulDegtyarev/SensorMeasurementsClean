package SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Delete;

import java.sql.Timestamp;
import java.time.Instant;

public class MeteostationsSensorsDeleteRequestBody {
    private Timestamp removed_ts;

    public MeteostationsSensorsDeleteRequestBody(Timestamp removed_ts) {
        this.removed_ts = removed_ts;
    }

    public MeteostationsSensorsDeleteRequestBody(){}

    public Timestamp getRemoved_ts() {
        return removed_ts;
    }

    public void setRemoved_ts(Timestamp removed_ts) {
        this.removed_ts = removed_ts;
    }
}
