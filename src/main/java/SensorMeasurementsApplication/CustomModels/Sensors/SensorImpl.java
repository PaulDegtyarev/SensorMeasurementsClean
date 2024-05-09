package SensorMeasurementsApplication.CustomModels.Sensors;

import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsMeasurementsRequestBodyList;

import java.util.List;

public class SensorImpl implements Sensor {
    private String sensorName;
    private List<SensorsMeasurementsRequestBodyList> sensorsMeasurements;

    public SensorImpl(String sensorName, List<SensorsMeasurementsRequestBodyList> sensorsMeasurements) {
        this.sensorName = sensorName;
        this.sensorsMeasurements = sensorsMeasurements;
    }


    @Override
    public String getSensorName() {
        return sensorName;
    }
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    @Override
    public List<SensorsMeasurementsRequestBodyList> getSensorsMeasurements() {
        return sensorsMeasurements;
    }

    public void setSensorsMeasurements(List<SensorsMeasurementsRequestBodyList> sensorsMeasurements) {
        this.sensorsMeasurements = sensorsMeasurements;
    }
}
