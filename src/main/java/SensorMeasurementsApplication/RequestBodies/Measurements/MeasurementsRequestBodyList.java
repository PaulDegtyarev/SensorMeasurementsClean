package SensorMeasurementsApplication.RequestBodies.Measurements;

import java.util.List;

public class MeasurementsRequestBodyList {
    private List<MeasurementsRequestBody> measurements;

    public MeasurementsRequestBodyList(List<MeasurementsRequestBody> measurements) {
        this.measurements = measurements;
    }

    public MeasurementsRequestBodyList(){}
    public List<MeasurementsRequestBody> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementsRequestBody> measurements) {
        this.measurements = measurements;
    }
}
