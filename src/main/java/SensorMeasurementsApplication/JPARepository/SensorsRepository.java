package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorsRepository extends JpaRepository<SensorsEntity, Integer> {
}
