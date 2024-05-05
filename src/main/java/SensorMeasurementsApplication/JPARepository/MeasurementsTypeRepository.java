package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementsTypeRepository extends JpaRepository<MeasurementsTypeEntity, Integer> {
}
