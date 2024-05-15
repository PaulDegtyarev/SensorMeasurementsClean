package SensorMeasurementsApplication.RequestBodies.MeteostationsSensors;

import java.time.Instant;

public class MSRequestBodyList {
    private Integer station_id;
    private Integer sensor_id;
    private Instant added_ts;

    public MSRequestBodyList(Integer station_id, Integer sensor_id, Instant added_ts) {
        this.station_id = station_id;
        this.sensor_id = sensor_id;
        this.added_ts = added_ts;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }

    public Instant getAdded_ts() {
        return added_ts;
    }

    public void setAdded_ts(Instant added_ts) {
        this.added_ts = added_ts;
    }
}
