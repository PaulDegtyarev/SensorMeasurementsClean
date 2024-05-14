package SensorMeasurementsApplication.Responses.SensorsMeasurements;

public class SensorsMeasurementsResponseList {
    private Integer sensor_id;
    private String sensor_name;
    private Integer type_id;
    private String type_name;
    private String type_units;
    private String type_formula;

    public SensorsMeasurementsResponseList(Integer sensor_id, String sensor_name, Integer type_id, String type_name, String type_units, String type_formula) {
        this.sensor_id = sensor_id;
        this.sensor_name = sensor_name;
        this.type_id = type_id;
        this.type_name = type_name;
        this.type_units = type_units;
        this.type_formula = type_formula;
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

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_units() {
        return type_units;
    }

    public void setType_units(String type_units) {
        this.type_units = type_units;
    }

    public String getType_formula() {
        return type_formula;
    }

    public void setType_formula(String type_formula) {
        this.type_formula = type_formula;
    }
}
