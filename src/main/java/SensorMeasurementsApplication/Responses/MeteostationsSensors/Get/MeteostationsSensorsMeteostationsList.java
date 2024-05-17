package SensorMeasurementsApplication.Responses.MeteostationsSensors.Get;

import java.util.List;

public class MeteostationsSensorsMeteostationsList {
    private MeteostationsSensorsMeteostationInfo meteostation;

    public MeteostationsSensorsMeteostationsList(MeteostationsSensorsMeteostationInfo meteostation) {
        this.meteostation = meteostation;
    }

    public MeteostationsSensorsMeteostationInfo getMeteostation() {
        return meteostation;
    }

    public void setMeteostation(MeteostationsSensorsMeteostationInfo meteostation) {
        this.meteostation = meteostation;
    }
}
