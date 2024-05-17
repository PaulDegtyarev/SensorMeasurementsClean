package SensorMeasurementsApplication.Responses.MeteostationsSensors.Get;

import java.sql.Timestamp;
import java.time.Instant;

public class MeteostationsSensorsSensorsList {
    private Integer sensor_inventory_number;
    private Integer sensor_id;
    private String sensor_name;
    private Instant sensor_added_ts;
    private Timestamp sensor_remove_ts;

    public MeteostationsSensorsSensorsList(Integer sensor_inventory_number, Integer sensor_id, String sensor_name, Instant sensor_added_ts, Timestamp sensor_remove_ts) {
        this.sensor_inventory_number = sensor_inventory_number;
        this.sensor_id = sensor_id;
        this.sensor_name = sensor_name;
        this.sensor_added_ts = sensor_added_ts;
        this.sensor_remove_ts = sensor_remove_ts;
    }

    public Integer getSensor_inventory_number() {
        return sensor_inventory_number;
    }

    public void setSensor_inventory_number(Integer sensor_inventory_number) {
        this.sensor_inventory_number = sensor_inventory_number;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public Instant getSensor_added_ts() {
        return sensor_added_ts;
    }

    public void setSensor_added_ts(Instant sensor_added_ts) {
        this.sensor_added_ts = sensor_added_ts;
    }

    public Timestamp getSensor_remove_ts() {
        return sensor_remove_ts;
    }

    public void setSensor_remove_ts(Timestamp sensor_remove_ts) {
        this.sensor_remove_ts = sensor_remove_ts;
    }
}
