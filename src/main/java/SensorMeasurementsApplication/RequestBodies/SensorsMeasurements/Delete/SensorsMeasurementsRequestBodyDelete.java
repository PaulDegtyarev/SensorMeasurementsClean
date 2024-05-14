package SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Delete;

import java.util.List;

public class SensorsMeasurementsRequestBodyDelete {
    private List<Integer> measurements_type;

    public SensorsMeasurementsRequestBodyDelete(List<Integer> measurements_type) {
        this.measurements_type = measurements_type;
    }

    public SensorsMeasurementsRequestBodyDelete(){}

    public List<Integer> getMeasurements_type() {
        return measurements_type;
    }

    public void setMeasurements_type(List<Integer> measurements_type) {
        this.measurements_type = measurements_type;
    }
}
