package SensorMeasurementsApplication.JPAEntities.Measurements;

import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "measurements", schema = "public")
public class MeasurementsEntity {
    @EmbeddedId private MeasurementsKey measurementsKey;

    @ManyToOne
    @JoinColumn(name = "sensor_inventory_number", insertable = false, updatable = false)
    private MeteostationsSensorsEntity meteostationsSensors;

    @ManyToOne
    @JoinColumn(name = "measurement_type", insertable = false, updatable = false)
    private MeasurementsTypeEntity measurementsType;


    public MeasurementsEntity(MeasurementsKey measurementsKey) {
        this.measurementsKey = measurementsKey;
    }

    public MeasurementsEntity(){}

    public MeasurementsKey getMeasurementsKey() {
        return measurementsKey;
    }

    public void setMeasurementsKey(MeasurementsKey measurementsKey) {
        this.measurementsKey = measurementsKey;
    }

    public MeteostationsSensorsEntity getMeteostationsSensors() {
        return meteostationsSensors;
    }

    public void setMeteostationsSensors(MeteostationsSensorsEntity meteostationsSensors) {
        this.meteostationsSensors = meteostationsSensors;
    }

    public MeasurementsTypeEntity getMeasurementsType() {
        return measurementsType;
    }

    public void setMeasurementsType(MeasurementsTypeEntity measurementsType) {
        this.measurementsType = measurementsType;
    }
}
