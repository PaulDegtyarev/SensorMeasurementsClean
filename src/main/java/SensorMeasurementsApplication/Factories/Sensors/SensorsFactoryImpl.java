package SensorMeasurementsApplication.Factories.Sensors;

import SensorMeasurementsApplication.CustomModels.Sensors.Sensor;
import SensorMeasurementsApplication.CustomModels.Sensors.SensorImpl;
import org.springframework.stereotype.Component;

@Component
public class SensorsFactoryImpl implements SensorsFactory{
    @Override
    public Sensor create(String sensorName){
        return new SensorImpl(sensorName);
    }
}
