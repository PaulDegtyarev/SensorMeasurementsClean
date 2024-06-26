package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorsMeasurementsRepository extends JpaRepository<SensorsMeasurementsEntity, SensorsMeasurementsKey> {
}
