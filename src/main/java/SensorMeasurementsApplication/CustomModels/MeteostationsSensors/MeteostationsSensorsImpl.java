package SensorMeasurementsApplication.CustomModels.MeteostationsSensors;

import java.sql.Timestamp;
import java.time.Instant;

public class MeteostationsSensorsImpl implements MeteostationsSensors{
    private Integer sensorInventoryNumber;
    private Integer stationId;
    private Integer sensorId;
    private Instant addedTS;
    private Timestamp removedTS;


    public MeteostationsSensorsImpl(Integer sensorInventoryNumber, Integer stationId, Integer sensorId, Instant addedTS, Timestamp removedTS) {
        this.sensorInventoryNumber = sensorInventoryNumber;
        this.stationId = stationId;
        this.sensorId = sensorId;
        this.addedTS = addedTS;
        this.removedTS = removedTS;
    }

    public MeteostationsSensorsImpl(){}

    @Override
    public Integer getSensorInventoryNumber() {
        return sensorInventoryNumber;
    }

    public void setSensorInventoryNumber(Integer sensorInventoryNumber) {
        this.sensorInventoryNumber = sensorInventoryNumber;
    }

    @Override
    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Override
    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public Instant getAddedTS() {
        return addedTS;
    }

    public void setAddedTS(Instant addedTS) {
        this.addedTS = addedTS;
    }

    @Override
    public Timestamp getRemovedTS() {
        return removedTS;
    }

    public void setRemovedTS(Timestamp removedTS) {
        this.removedTS = removedTS;
    }
}
