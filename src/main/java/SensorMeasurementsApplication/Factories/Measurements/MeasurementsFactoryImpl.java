package SensorMeasurementsApplication.Factories.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.CustomModels.Measurements.MeasurementsImpl;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsFactoryImpl implements MeasurementsFactory{

    @Override
    public Measurements create(MeasurementsRequestBody data){
        return new MeasurementsImpl(data.getMeasurement_value(), data.getMeasurement_ts(), data.getSensor_inventory_number(), data.getMeasurement_type());
    }
}
