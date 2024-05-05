package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteostationsSensorsRepository extends JpaRepository<MeteostationsSensorsEntity, Integer> {
}
