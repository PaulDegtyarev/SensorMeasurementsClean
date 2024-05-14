package SensorMeasurementsApplication.Responses.SensorsMeasurements;

import java.util.List;

public class SensorsMeasurementsResponseModel {
    private List<SensorsMeasurementsResponseList> sensors_measurements;

    public SensorsMeasurementsResponseModel(List<SensorsMeasurementsResponseList> sensors_measurements) {
        this.sensors_measurements = sensors_measurements;
    }

    public List<SensorsMeasurementsResponseList> getSensors_measurements() {
        return sensors_measurements;
    }

    public void setSensors_measurements(List<SensorsMeasurementsResponseList> sensors_measurements) {
        this.sensors_measurements = sensors_measurements;
    }
}
