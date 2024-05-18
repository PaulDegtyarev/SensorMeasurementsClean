package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeteostationsSensorsRepository extends JpaRepository<MeteostationsSensorsEntity, Integer> {
    boolean existsByStationId(Integer stationId);

    boolean existsByStationIdAndSensorId(Integer stationId, Integer sensorId);

    boolean existsBySensorInventoryNumber(Integer sensorInventoryNumber);

    boolean existsBySensorId(Integer sensorId);
}
