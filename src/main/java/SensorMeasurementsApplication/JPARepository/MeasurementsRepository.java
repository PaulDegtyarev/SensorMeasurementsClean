package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementsRepository extends JpaRepository<MeasurementsEntity, MeasurementsKey> {
    boolean existsByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber);

    List<MeasurementsEntity> findAllByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber);

}
