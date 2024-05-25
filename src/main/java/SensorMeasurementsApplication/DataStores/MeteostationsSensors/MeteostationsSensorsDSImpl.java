package SensorMeasurementsApplication.DataStores.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.Exceptions.Meteostations.MeteostationsNotFoundException;
import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsInvNumbNotFoundException;
import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.JPARepository.MeteostationsRepository;
import SensorMeasurementsApplication.JPARepository.MeteostationsSensorsRepository;
import SensorMeasurementsApplication.JPARepository.SensorsRepository;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModel;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModelForDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Component
public class MeteostationsSensorsDSImpl implements MeteostationsSensorsDS {
    private MeteostationsSensorsRepository meteostationsSensorsRepository;
    private MeteostationsRepository meteostationsRepository;
    private SensorsRepository sensorsRepository;

    @Autowired
    public MeteostationsSensorsDSImpl(MeteostationsSensorsRepository meteostationsSensorsRepository, MeteostationsRepository meteostationsRepository, SensorsRepository sensorsRepository) {
        this.meteostationsSensorsRepository = meteostationsSensorsRepository;
        this.meteostationsRepository = meteostationsRepository;
        this.sensorsRepository = sensorsRepository;
    }

    @Override
    public List<MeteostationsSensorsEntity> create(MeteostationsSensorsDSRequestModel dsRequest){
        List<MeteostationsSensorsEntity> dsresponse = new ArrayList<>();
        for (MeteostationsSensors el : dsRequest.getMeteostationsSensors()){
            MeteostationsSensorsEntity meteostationsSensors = new MeteostationsSensorsEntity(el.getStationId(), el.getSensorId(), el.getAddedTS());
            meteostationsSensorsRepository.save(meteostationsSensors);

            dsresponse.add(meteostationsSensors);
        }

        return dsresponse;
    }

    @Override
    public void delete(MeteostationsSensorsDSRequestModelForDelete dsRequest){
        MeteostationsSensorsEntity meteostationsSensors = meteostationsSensorsRepository.findById(dsRequest.getSensorInventoryNumber()).orElseThrow(MeteostationsSensorsInvNumbNotFoundException::new);
        meteostationsSensors.setRemovedTS(dsRequest.getRemovedTS());
        meteostationsSensorsRepository.save(meteostationsSensors);
    }

    @Override
    public List<MeteostationsSensorsEntity> get(){
        return meteostationsSensorsRepository.findAll();
    }

    @Override
    public boolean existsByStationIdAndSensorId(Integer stationId, Integer sensorId){
        return meteostationsSensorsRepository.existsByStationIdAndSensorId(stationId, sensorId);
    }

    @Override
    public boolean existsBySensorInventoryNumber(Integer sensorInventoryNumber){return meteostationsSensorsRepository.existsBySensorInventoryNumber(sensorInventoryNumber);}

    @Override
    public boolean existsByStationId(Integer stationId){
        return meteostationsRepository.existsByStationId(stationId);
    }

    @Override
    public boolean existsBySensorId(Integer sensorId){return sensorsRepository.existsBySensorId(sensorId);}

    @Override
    public MeteostationsEntity one(Integer stationId){return meteostationsRepository.findById(stationId).orElseThrow(MeteostationsNotFoundException::new);}


}
