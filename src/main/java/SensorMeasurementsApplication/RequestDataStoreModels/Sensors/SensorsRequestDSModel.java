package SensorMeasurementsApplication.RequestDataStoreModels.Sensors;

import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsMeasurementsRequestBodyList;

import java.util.List;

public class SensorsRequestDSModel {
    private String sensorName;
    private List<SensorsMeasurementsRequestBodyList> sensorsMeasurements;

    public SensorsRequestDSModel(String sensorName, List<SensorsMeasurementsRequestBodyList> sensorsMeasurements) {
        this.sensorName = sensorName;
        this.sensorsMeasurements = sensorsMeasurements;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public List<SensorsMeasurementsRequestBodyList> getSensorsMeasurements() {
        return sensorsMeasurements;
    }

    public void setSensorsMeasurements(List<SensorsMeasurementsRequestBodyList> sensorsMeasurements) {
        this.sensorsMeasurements = sensorsMeasurements;
    }
}
