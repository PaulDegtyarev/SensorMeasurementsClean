package SensorMeasurementsApplication.RequestBodies.MeasurementsTypesRequestBody;

public class MeasurementsTypesRequestBody {
    private String type_name;
    private String type_units;

    public MeasurementsTypesRequestBody( String type_name, String type_units) {
        this.type_name = type_name;
        this.type_units = type_units;
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
