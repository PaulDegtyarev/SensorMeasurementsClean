package SensorMeasurementsApplication.Responses.Sensors.GetTypes;

import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsMeasurementsResponseModelPostList;

import java.util.List;

public class SensorsResponseModelGetTypes {
    private List<SensorsMeasurementsResponseModelPostList> measurements;

    public SensorsResponseModelGetTypes(List<SensorsMeasurementsResponseModelPostList> measurements) {
        this.measurements = measurements;
    }

    public List<SensorsMeasurementsResponseModelPostList> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<SensorsMeasurementsResponseModelPostList> measurements) {
        this.measurements = measurements;
    }
}
