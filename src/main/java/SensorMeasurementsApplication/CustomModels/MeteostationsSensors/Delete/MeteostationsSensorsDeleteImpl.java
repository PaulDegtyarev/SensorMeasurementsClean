package SensorMeasurementsApplication.CustomModels.MeteostationsSensors.Delete;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;

public class MeteostationsSensorsDeleteImpl implements MeteostationsSensorsDelete{
    private Integer sensorInventoryNumber;
    private Timestamp removedTS;

    public MeteostationsSensorsDeleteImpl(Integer sensorInventoryNumber, Timestamp removedTS) {
        this.sensorInventoryNumber = sensorInventoryNumber;
        this.removedTS = removedTS;
    }

    @Override
    public Integer getSensorInventoryNumber() {
        return sensorInventoryNumber;
    }

    public void setSensorInventoryNumber(Integer sensorInventoryNumber) {
        this.sensorInventoryNumber = sensorInventoryNumber;
    }

    @Override
    public Timestamp getRemovedTS() {
        return removedTS;
    }

    public void setRemovedTS(Timestamp removedTS) {
        this.removedTS = removedTS;
    }
}
