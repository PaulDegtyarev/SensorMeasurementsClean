package SensorMeasurementsApplication.Responses.Measurements.Post;

import java.util.List;

public class MeasurementsPostResponseModel {
    private List<MeasurementsPostResponseList> measurements;

    public MeasurementsPostResponseModel(List<MeasurementsPostResponseList> measurements) {
        this.measurements = measurements;
    }

    public List<MeasurementsPostResponseList> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementsPostResponseList> measurements) {
        this.measurements = measurements;
    }
}
