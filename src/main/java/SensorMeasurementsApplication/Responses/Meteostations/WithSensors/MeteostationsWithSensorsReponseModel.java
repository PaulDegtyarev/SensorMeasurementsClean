package SensorMeasurementsApplication.Responses.Meteostations.WithSensors;

import SensorMeasurementsApplication.Responses.Meteostations.MeteostationResponseModel;
import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsResponseModelPost;

import java.util.List;

public class MeteostationsWithSensorsReponseModel {
    private MeteostationResponseModel meteostation;
    private List<SensorsList> sensors;

    public MeteostationsWithSensorsReponseModel(MeteostationResponseModel meteostation, List<SensorsList> sensors) {
        this.meteostation = meteostation;
        this.sensors = sensors;
    }

    public MeteostationResponseModel getMeteostation() {
        return meteostation;
    }

    public void setMeteostation(MeteostationResponseModel meteostation) {
        this.meteostation = meteostation;
    }

    public List<SensorsList> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorsList> sensors) {
        this.sensors = sensors;
    }
}
