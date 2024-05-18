package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MeasurementsRepository extends JpaRepository<MeasurementsEntity, MeasurementsKey> {
    boolean existsByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber);

    List<MeasurementsEntity> findAllByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber);

    @Query(value = "select * from measurements where measurement_ts >= :from and measurement_ts <= :to", nativeQuery = true)
    List<MeasurementsEntity> findByMeasurementsKey_MeasurementTS(@Param("from") Timestamp from, @Param("to") Timestamp to);

}
