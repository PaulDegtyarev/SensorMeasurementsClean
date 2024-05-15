package SensorMeasurementsApplication.Factories.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensorsImpl;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.MSRequestBodyList;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.MeteostationsSensorsRequestBody;
import org.springframework.stereotype.Component;

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
}
