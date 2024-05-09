package SensorMeasurementsApplication.Responses.MeasurementsTypes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MeasurementsTypeResponseModelPost {
    private Integer type_id;
    private String type_name;
    private String type_units;

    public MeasurementsTypeResponseModelPost(Integer type_id, String type_name, String type_units) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.type_units = type_units;
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
}
