package SensorMeasurementsApplication.Factories.SensorsMeasurements;

import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurements;
import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurementsImpl;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Post.SensorsMeasurementsRequesBody;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Post.SensorsMeasurementsRequesBodyList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SensorsMeasurementsFactoryImpl implements SensorsMeasurementsFactory {
    @Override
    public List<SensorsMeasurements> create(Integer sensorId, SensorsMeasurementsRequesBody data){
        List<SensorsMeasurements> modelsList = new ArrayList<>();
        for (SensorsMeasurementsRequesBodyList el : data.getSensors_measurements()){
            SensorsMeasurementsImpl model = new SensorsMeasurementsImpl(sensorId, el.getType_id(), el.getType_formula());
            modelsList.add(model);
        }
        return modelsList;
    }
}
