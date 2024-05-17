package SensorMeasurementsApplication.DataStores.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsNotFoundException;
import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.JPARepository.MeteostationsRepository;
import SensorMeasurementsApplication.JPARepository.MeteostationsSensorsRepository;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModel;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModelForDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeteostationsSensorsDSImpl implements MeteostationsSensorsDS {
    @Autowired
    private MeteostationsSensorsRepository meteostationsSensorsRepository;
    private MeteostationsRepository meteostationsRepository;

    public MeteostationsSensorsDSImpl(MeteostationsSensorsRepository meteostationsSensorsRepository, MeteostationsRepository meteostationsRepository) {
        this.meteostationsSensorsRepository = meteostationsSensorsRepository;
        this.meteostationsRepository = meteostationsRepository;
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
        MeteostationsSensorsEntity meteostationsSensors = meteostationsSensorsRepository.findById(dsRequest.getSensorInventoryNumber()).orElseThrow(MeteostationsSensorsNotFoundException::new);
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
}
