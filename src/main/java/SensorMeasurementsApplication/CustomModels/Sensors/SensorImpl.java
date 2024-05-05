package SensorMeasurementsApplication.CustomModels.Sensors;

public class SensorImpl implements Sensor {
    private String sensorName;

    public SensorImpl(String sensorName) {
        this.sensorName = sensorName;
    }

    public SensorImpl(){}

    @Override
    public String getSensorName() {
        return sensorName;
    }
    @Override
    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }
}
