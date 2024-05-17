package SensorMeasurementsApplication.CustomModels.MeteostationsSensors;

import java.sql.Timestamp;
import java.time.Instant;

public class MeteostationsSensorsImpl implements MeteostationsSensors{
        private Integer stationId;
        private Integer sensorId;
        private Instant addedTS;


    public MeteostationsSensorsImpl(Integer stationId, Integer sensorId, Instant addedTS) {
        this.stationId = stationId;
        this.sensorId = sensorId;
        this.addedTS = addedTS;
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
}
