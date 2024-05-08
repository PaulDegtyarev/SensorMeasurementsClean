package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeteostationsSensorsRepository extends JpaRepository<MeteostationsSensorsEntity, Integer> {
    boolean existsBySensorId(Integer sensorId);
}
