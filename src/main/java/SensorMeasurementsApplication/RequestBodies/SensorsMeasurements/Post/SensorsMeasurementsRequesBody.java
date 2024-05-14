package SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Post;

import java.util.List;

public class SensorsMeasurementsRequesBody {
    private List<SensorsMeasurementsRequesBodyList> sensors_measurements;

    public SensorsMeasurementsRequesBody(List<SensorsMeasurementsRequesBodyList> sensors_measurements) {
        this.sensors_measurements = sensors_measurements;
    }

    public SensorsMeasurementsRequesBody(){}

    public List<SensorsMeasurementsRequesBodyList> getSensors_measurements() {
        return sensors_measurements;
    }

    public void setSensors_measurements(List<SensorsMeasurementsRequesBodyList> sensors_measurements) {
        this.sensors_measurements = sensors_measurements;
    }
}
