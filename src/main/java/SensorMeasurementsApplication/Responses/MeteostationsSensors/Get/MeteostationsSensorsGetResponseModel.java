package SensorMeasurementsApplication.Responses.MeteostationsSensors.Get;

import java.util.List;

public class MeteostationsSensorsGetResponseModel {
    private List<MeteostationsSensorsMeteostationsList> meteostations_sensors;

    public MeteostationsSensorsGetResponseModel(List<MeteostationsSensorsMeteostationsList> meteostations_sensors) {
        this.meteostations_sensors = meteostations_sensors;
    }

    public List<MeteostationsSensorsMeteostationsList> getMeteostations_sensors() {
        return meteostations_sensors;
    }

    public void setMeteostations_sensors(List<MeteostationsSensorsMeteostationsList> meteostations_sensors) {
        this.meteostations_sensors = meteostations_sensors;
    }
}
