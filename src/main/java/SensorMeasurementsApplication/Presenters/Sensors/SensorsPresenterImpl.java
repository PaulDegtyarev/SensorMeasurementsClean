package SensorMeasurementsApplication.Presenters.Sensors;

import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeNotFoundException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsConfictException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsHasMeasurementsException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsNotFoundException;
import SensorMeasurementsApplication.Responses.Sensors.GetAll.SensorsResponseModelGetAll;
import SensorMeasurementsApplication.Responses.Sensors.GetTypes.SensorsResponseModelGetTypes;
import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsResponseModelPost;
import org.springframework.stereotype.Component;

@Component
public class SensorsPresenterImpl implements SensorsPresenter {
    @Override
    public SensorsResponseModelPost prepareSuccessView(SensorsResponseModelPost response){
        return response;
    }

    @Override
    public MeasurementsTypeNotFoundException prepareMeasurementTypeNotFoundView(){throw new MeasurementsTypeNotFoundException();}

    @Override
    public SensorsConfictException prepareSensorsConflictView(){throw new SensorsConfictException();}

    @Override
    public SensorsNotFoundException prepareSensorsNotFoundView(){throw new SensorsNotFoundException();}

    @Override
    public SensorsHasMeasurementsException prepareSensorsHasMeasurementsView(){throw new SensorsHasMeasurementsException("Sensor has measurements");}

    @Override
    public SensorsResponseModelGetAll prepareSuccessGetAllView(SensorsResponseModelGetAll response){return response;}


    @Override
    public SensorsResponseModelGetTypes prepareSuccessGetTypeView(SensorsResponseModelGetTypes response){return response;}

}



