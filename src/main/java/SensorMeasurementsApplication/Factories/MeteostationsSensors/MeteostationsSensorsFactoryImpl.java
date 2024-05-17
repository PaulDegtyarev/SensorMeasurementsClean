package SensorMeasurementsApplication.Factories.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.Delete.MeteostationsSensorsDelete;
import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.Delete.MeteostationsSensorsDeleteImpl;
import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensorsImpl;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Delete.MeteostationsSensorsDeleteRequestBody;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Post.MSRequestBodyList;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Post.MeteostationsSensorsRequestBody;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
public class MeteostationsSensorsFactoryImpl implements MeteostationsSensorsFactory {
    @Override
    public List<MeteostationsSensors> create(MeteostationsSensorsRequestBody data){
        List<MeteostationsSensors> modelsList = new ArrayList<>();

        for (MSRequestBodyList el : data.getMeteostations_sensors()){
            MeteostationsSensors model = new MeteostationsSensorsImpl(el.getStation_id(), el.getSensor_id(), el.getAdded_ts());
            modelsList.add(model);
        }
        return modelsList;
    }

    @Override
    public MeteostationsSensorsDelete createForDelete(Integer sensorInventoryNumber, MeteostationsSensorsDeleteRequestBody data){
        if (data.getRemoved_ts() == null) data.setRemoved_ts(new Timestamp(System.currentTimeMillis()));
        return new MeteostationsSensorsDeleteImpl(sensorInventoryNumber, data.getRemoved_ts());
    }
}
