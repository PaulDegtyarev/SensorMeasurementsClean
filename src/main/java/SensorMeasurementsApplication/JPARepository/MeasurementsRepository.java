package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsRepository extends JpaRepository<MeasurementsEntity, MeasurementsKey> {
}
