package SensorMeasurementsApplication.RequestDataStoreModels.SensorsMeasurements;

import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurements;

import java.util.List;

public class SensorsMeasurementsDSRequestModel {
    private List<SensorsMeasurements> sensorsMeasurements;

    public SensorsMeasurementsDSRequestModel(List<SensorsMeasurements> sensorsMeasurements) {
        this.sensorsMeasurements = sensorsMeasurements;
    }

    public List<SensorsMeasurements> getSensorsMeasurements() {
        return sensorsMeasurements;
    }

    public void setSensorsMeasurements(List<SensorsMeasurements> sensorsMeasurements) {
        this.sensorsMeasurements = sensorsMeasurements;
    }
}
