package SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;

import java.util.List;

public class MeteostationsSensorsDSRequestModel {
    private List<MeteostationsSensors> meteostationsSensors;

    public MeteostationsSensorsDSRequestModel(List<MeteostationsSensors> meteostationsSensors) {
        this.meteostationsSensors = meteostationsSensors;
    }

    public List<MeteostationsSensors> getMeteostationsSensors() {
        return meteostationsSensors;
    }

    public void setMeteostationsSensors(List<MeteostationsSensors> meteostationsSensors) {
        this.meteostationsSensors = meteostationsSensors;
    }
}
