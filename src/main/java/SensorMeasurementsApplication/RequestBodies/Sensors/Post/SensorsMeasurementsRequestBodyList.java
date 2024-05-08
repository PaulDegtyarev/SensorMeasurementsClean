package SensorMeasurementsApplication.RequestBodies.Sensors.Post;

public class SensorsMeasurementsRequestBodyList {
    private Integer type_id;
    private String type_formula;


    public SensorsMeasurementsRequestBodyList(Integer type_id, String type_formula) {
        this.type_id = type_id;
        this.type_formula = type_formula;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_formula() {
        return type_formula;
    }

    public void setType_formula(String type_formula) {
        this.type_formula = type_formula;
    }
}
