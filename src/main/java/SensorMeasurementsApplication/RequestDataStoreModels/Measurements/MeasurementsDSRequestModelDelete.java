package SensorMeasurementsApplication.RequestDataStoreModels.Measurements;

import java.sql.Timestamp;

public class MeasurementsDSRequestModelDelete {
    private Timestamp from;
    private Timestamp to;

    public MeasurementsDSRequestModelDelete(Timestamp from, Timestamp to) {
        this.from = from;
        this.to = to;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }
}
