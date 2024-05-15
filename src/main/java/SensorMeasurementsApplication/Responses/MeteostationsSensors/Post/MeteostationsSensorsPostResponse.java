package SensorMeasurementsApplication.Responses.MeteostationsSensors.Post;

import java.util.List;

public class MeteostationsSensorsPostResponse {
    private List<MSPostList> meteostations_sensors;

    public MeteostationsSensorsPostResponse(List<MSPostList> meteostations_sensors) {
        this.meteostations_sensors = meteostations_sensors;
    }

    public List<MSPostList> getMeteostations_sensors() {
        return meteostations_sensors;
    }

    public void setMeteostations_sensors(List<MSPostList> meteostations_sensors) {
        this.meteostations_sensors = meteostations_sensors;
    }
}
