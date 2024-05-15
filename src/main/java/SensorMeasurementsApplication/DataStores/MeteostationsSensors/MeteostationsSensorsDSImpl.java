package SensorMeasurementsApplication.DataStores.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.JPARepository.MeteostationsSensorsRepository;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeteostationsSensorsDSImpl implements MeteostationsSensorsDS {
    @Autowired
    private MeteostationsSensorsRepository meteostationsSensorsRepository;

    public MeteostationsSensorsDSImpl(MeteostationsSensorsRepository meteostationsSensorsRepository) {
        this.meteostationsSensorsRepository = meteostationsSensorsRepository;
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
    public boolean existsByStationIdAndSensorId(Integer stationId, Integer sensorId){
        return meteostationsSensorsRepository.existsByStationIdAndSensorId(stationId, sensorId);
    }
}
