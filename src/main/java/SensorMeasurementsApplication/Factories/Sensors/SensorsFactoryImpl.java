package SensorMeasurementsApplication.Factories.Sensors;

import SensorMeasurementsApplication.CustomModels.Sensors.Sensor;
import SensorMeasurementsApplication.CustomModels.Sensors.SensorImpl;
import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsPostRequestBody;
import org.springframework.stereotype.Component;

@Component
public class SensorsFactoryImpl implements SensorsFactory{
    @Override
    public Sensor create(SensorsPostRequestBody data){
        return new SensorImpl(data.getSensor_name(), data.getSensors_measurements());
    }
}
