package SensorMeasurementsApplication.CustomModels.Measurements.Delete;

import java.sql.Timestamp;

public class MeasurementsDeleteImpl implements MeasurementsDelete{
    private Timestamp from;
    private Timestamp to;

    public MeasurementsDeleteImpl(Timestamp from, Timestamp to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    @Override
    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }
}
