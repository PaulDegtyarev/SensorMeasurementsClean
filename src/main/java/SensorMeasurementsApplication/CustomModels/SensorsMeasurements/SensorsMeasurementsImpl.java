package SensorMeasurementsApplication.CustomModels.SensorsMeasurements;

public class SensorsMeasurementsImpl implements SensorsMeasurements{
    private Integer sensorId;
    private Integer typeId;
    private String typeFormula;

    public SensorsMeasurementsImpl(Integer sensorId, Integer typeId, String typeFormula) {
        this.sensorId = sensorId;
        this.typeId = typeId;
        this.typeFormula = typeFormula;
    }

    public SensorsMeasurementsImpl(){}

    @Override
    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String getTypeFormula() {
        return typeFormula;
    }

    public void setTypeFormula(String typeFormula) {
        this.typeFormula = typeFormula;
    }
}
