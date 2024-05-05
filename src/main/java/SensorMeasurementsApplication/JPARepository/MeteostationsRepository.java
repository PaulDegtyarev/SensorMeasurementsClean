package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteostationsRepository extends JpaRepository<MeteostationsEntity, Integer> {
}
