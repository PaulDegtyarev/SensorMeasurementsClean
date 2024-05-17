package SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Post;

import java.util.List;

public class MeteostationsSensorsRequestBody {
    private List<MSRequestBodyList> meteostations_sensors;

    public MeteostationsSensorsRequestBody(List<MSRequestBodyList> meteostations_sensors) {
        this.meteostations_sensors = meteostations_sensors;
    }

    public MeteostationsSensorsRequestBody(){}
    public List<MSRequestBodyList> getMeteostations_sensors() {
        return meteostations_sensors;
    }

    public void setMeteostations_sensors(List<MSRequestBodyList> meteostations_sensors) {
        this.meteostations_sensors = meteostations_sensors;
    }
}
