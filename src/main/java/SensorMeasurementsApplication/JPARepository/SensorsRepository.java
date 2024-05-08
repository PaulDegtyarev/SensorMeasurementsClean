package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorsRepository extends JpaRepository<SensorsEntity, Integer> {
    boolean existsBySensorName(String sensorName);

    boolean existsBySensorId(Integer sensorId);
}
