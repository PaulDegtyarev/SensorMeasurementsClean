package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementsTypeRepository extends JpaRepository<MeasurementsTypeEntity, Integer> {
    boolean existsByTypeId(Integer typeId);
}
