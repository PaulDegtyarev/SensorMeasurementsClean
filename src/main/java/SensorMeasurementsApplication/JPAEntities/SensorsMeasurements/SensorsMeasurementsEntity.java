package SensorMeasurementsApplication.JPAEntities.SensorsMeasurements;

import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "sensors_measurements", schema = "public")
public class SensorsMeasurementsEntity {
    @EmbeddedId private SensorsMeasurementsKey sensorsMeasurementsKey;
    @Column(name = "type_formula") private String typeFormula;

    @ManyToOne
    @JoinColumn(name = "sensor_id", insertable=false, updatable=false)
    private SensorsEntity sensor;

    @ManyToOne
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private MeasurementsTypeEntity measurementsTypes;

    public SensorsMeasurementsEntity(SensorsMeasurementsKey sensorsMeasurementsKey, String typeFormula) {
        this.sensorsMeasurementsKey = sensorsMeasurementsKey;
        this.typeFormula = typeFormula;
    }

    public SensorsMeasurementsEntity(){}


    public SensorsMeasurementsKey getSensorsMeasurementsKey() {
        return sensorsMeasurementsKey;
    }

    public void setSensorsMeasurementsKey(SensorsMeasurementsKey sensorsMeasurementsKey) {
        this.sensorsMeasurementsKey = sensorsMeasurementsKey;
    }

    public String getTypeFormula() {
        return typeFormula;
    }

    public void setTypeFormula(String typeFormula) {
        this.typeFormula = typeFormula;
    }

    public SensorsEntity getSensor() {
        return sensor;
    }

    public void setSensor(SensorsEntity sensor) {
        this.sensor = sensor;
    }

    public MeasurementsTypeEntity getMeasurementsTypes() {
        return measurementsTypes;
    }

    public void setMeasurementsTypes(MeasurementsTypeEntity measurementsTypes) {
        this.measurementsTypes = measurementsTypes;
    }
}
