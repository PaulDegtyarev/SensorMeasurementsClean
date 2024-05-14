package SensorMeasurementsApplication.DataStores.Meteostations;

import SensorMeasurementsApplication.Exceptions.Meteostations.MeteostationsNotFoundException;
import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.JPARepository.MeteostationsRepository;
import SensorMeasurementsApplication.JPARepository.MeteostationsSensorsRepository;
import SensorMeasurementsApplication.RequestBodies.Meteostations.MeteostationRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.Meteostations.MeteostationsDSRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeteostationsDSImpl implements MeteostationsDS{
    @Autowired
    private final MeteostationsRepository meteostationsRepository;
    private final MeteostationsSensorsRepository meteostationsSensorsRepository;

    public MeteostationsDSImpl(MeteostationsRepository meteostationsRepository, MeteostationsSensorsRepository meteostationsSensorsRepository) {
        this.meteostationsRepository = meteostationsRepository;
        this.meteostationsSensorsRepository = meteostationsSensorsRepository;
    }

    @Override
    public MeteostationsEntity create(MeteostationsDSRequestModel requestModel){
        MeteostationsEntity meteostation = new MeteostationsEntity(requestModel.getStationName(), requestModel.getStationLongitude(), requestModel.getStationLatitude(), requestModel.getStationCountry());
        meteostationsRepository.save(meteostation);
        return meteostation;
    }

    @Override
    public void delete(Integer stationId){
        MeteostationsEntity meteostation = meteostationsRepository.findById(stationId).orElseThrow(MeteostationsNotFoundException::new);
        for (MeteostationsSensorsEntity el : meteostation.getMeteostationsSensors()){
            meteostationsSensorsRepository.delete(el);
        }

        meteostationsRepository.delete(meteostation);
    }

    @Override
    public void update(Integer stationId, MeteostationRequestBody data){
        MeteostationsEntity meteostation = meteostationsRepository.findById(stationId).orElseThrow(MeteostationsNotFoundException::new);
        meteostation.setStationName(data.getStation_name());
        meteostation.setStationLongitude(data.getStation_longitude());
        meteostation.setStationLatitude(data.getStation_latitude());
        meteostation.setStationCountry(data.getStation_country());

        meteostationsRepository.save(meteostation);
    }

    @Override
    public List<MeteostationsEntity> all(){
        return meteostationsRepository.findAll();
    }

    @Override
    public MeteostationsEntity one(Integer stationId){return meteostationsRepository.findById(stationId).orElseThrow(MeteostationsNotFoundException::new);}

    @Override
    public List<MeteostationsEntity> byParam(MeteostationsDSRequestModel dsRequest){
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
        Example<MeteostationsEntity> exampleQuery = Example.of(new MeteostationsEntity(dsRequest.getStationName(), dsRequest.getStationLongitude(), dsRequest.getStationLatitude(), dsRequest.getStationCountry()), matcher);
        return meteostationsRepository.findAll(exampleQuery);
    }

    @Override
    public MeteostationsEntity withSensors(Integer stationId){return meteostationsRepository.findById(stationId).orElseThrow(MeteostationsNotFoundException::new);}

    @Override
    public boolean existsByStationNameOrStationLongitudeAndStationLatitude(String stationName,
                                                                           Double stationLongitude,
                                                                           Double stationLatitude)
    {return meteostationsRepository.existsByStationNameOrStationLongitudeAndStationLatitude(stationName, stationLongitude, stationLatitude);}

    @Override
    public boolean existsByStationId(Integer stationId){
        return meteostationsRepository.existsByStationId(stationId);
    }

    @Override
    public boolean hasMeasurements(Integer stationId){
        MeteostationsEntity meteostation = meteostationsRepository.findById(stationId).orElseThrow(MeteostationsNotFoundException::new);
        List<MeteostationsSensorsEntity> meteostationsSensorsList = meteostation.getMeteostationsSensors();
        for (MeteostationsSensorsEntity el : meteostationsSensorsList){
            if (!el.getMeasurement().isEmpty()) return true;
        }
        return false;
    }
}
