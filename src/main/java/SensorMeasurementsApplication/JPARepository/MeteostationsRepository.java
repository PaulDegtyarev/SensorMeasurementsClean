package SensorMeasurementsApplication.JPARepository;

import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import org.apache.catalina.LifecycleState;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeteostationsRepository extends JpaRepository<MeteostationsEntity, Integer> {
    boolean existsByStationNameOrStationLongitudeAndStationLatitude(String stationName,
                                                                   Double stationLongitude,
                                                                   Double stationLatitude);

    boolean existsByStationId(Integer stationId);
}
