package SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors;

import java.sql.Timestamp;
import java.time.Instant;

public class MeteostationsSensorsDSRequestModelForDelete {
    private Integer sensorInventoryNumber;
    private Timestamp removedTS;


    public MeteostationsSensorsDSRequestModelForDelete(Integer sensorInventoryNumber, Timestamp removedTS) {
        this.sensorInventoryNumber = sensorInventoryNumber;
        this.removedTS = removedTS;
    }

    public Integer getSensorInventoryNumber() {
        return sensorInventoryNumber;
    }

    public void setSensorInventoryNumber(Integer sensorInventoryNumber) {
        this.sensorInventoryNumber = sensorInventoryNumber;
    }

    public Timestamp getRemovedTS() {
        return removedTS;
    }

    public void setRemovedTS(Timestamp removedTS) {
        this.removedTS = removedTS;
    }
}
