package SensorMeasurementsApplication.JPAEntities;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "measurements_type", schema = "public")
public class MeasurementsTypeEntity {
    @Column(name = "type_id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer typeId;
    @Column(name = "type_name") private String typeName;
    @Column(name = "type_units") private String typeUnits;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "measurement_type")
    private List<MeasurementsEntity> measurements = new ArrayList<>();

    @OneToMany(mappedBy = "measurementsTypes", cascade = CascadeType.ALL)
    private Set<SensorsMeasurementsEntity> sensorsMeasurements;

    public MeasurementsTypeEntity(String typeName, String typeUnits) {
        this.typeName = typeName;
        this.typeUnits = typeUnits;
    }

    public MeasurementsTypeEntity(){}

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeUnits() {
        return typeUnits;
    }

    public void setTypeUnits(String typeUnits) {
        this.typeUnits = typeUnits;
    }

    public List<MeasurementsEntity> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<MeasurementsEntity> measurements) {
        this.measurements = measurements;
    }

    public Set<SensorsMeasurementsEntity> getSensorsMeasurements() {
        return sensorsMeasurements;
    }

    public void setSensorsMeasurements(Set<SensorsMeasurementsEntity> sensorsMeasurements) {
        this.sensorsMeasurements = sensorsMeasurements;
    }
}
