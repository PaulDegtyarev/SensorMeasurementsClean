package SensorMeasurementsApplication.ResponseDataStoreModels.Sensors;

import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;

import java.util.List;

public class SensorsDSResponsePost {
    private SensorsEntity sensor;
    private List<SensorsMeasurementsEntity> sensorsMeasurements;

    public SensorsDSResponsePost(SensorsEntity sensor, List<SensorsMeasurementsEntity> sensorsMeasurements) {
        this.sensor = sensor;
        this.sensorsMeasurements = sensorsMeasurements;
    }

    public SensorsEntity getSensor() {
        return sensor;
    }

    public void setSensor(SensorsEntity sensor) {
        this.sensor = sensor;
    }

    public List<SensorsMeasurementsEntity> getSensorsMeasurements() {
        return sensorsMeasurements;
    }

    public void setSensorsMeasurements(List<SensorsMeasurementsEntity> sensorsMeasurements) {
        this.sensorsMeasurements = sensorsMeasurements;
    }
}
