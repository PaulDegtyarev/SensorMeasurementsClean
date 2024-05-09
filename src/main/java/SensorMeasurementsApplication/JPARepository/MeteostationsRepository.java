package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeteostationsRepository extends JpaRepository<MeteostationsEntity, Integer> {
}
