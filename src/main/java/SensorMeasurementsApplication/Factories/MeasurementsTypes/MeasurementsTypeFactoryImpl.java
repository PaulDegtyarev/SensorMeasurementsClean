package SensorMeasurementsApplication.Factories.MeasurementsTypes;

import SensorMeasurementsApplication.CustomModels.MeasurementsTypes.MeasurementsType;
import SensorMeasurementsApplication.CustomModels.MeasurementsTypes.MeasurementsTypeImpl;
import SensorMeasurementsApplication.RequestBodies.MeasurementsTypesRequestBody.MeasurementsTypesRequestBody;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsTypeFactoryImpl implements MeasurementsTypeFactory {
    @Override
    public MeasurementsType create(MeasurementsTypesRequestBody data){
        return new MeasurementsTypeImpl(data.getType_name(), data.getType_units());
    }
}
