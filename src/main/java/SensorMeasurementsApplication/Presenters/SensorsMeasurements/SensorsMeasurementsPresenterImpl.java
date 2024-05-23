package SensorMeasurementsApplication.Presenters.SensorsMeasurements;

import SensorMeasurementsApplication.Exceptions.SensorsMeasurements.SensorsMeasurementsSensorNotFoundException;
import SensorMeasurementsApplication.Exceptions.SensorsMeasurements.SensorsMeasurementsTypeNotFoundException;
import SensorMeasurementsApplication.Responses.SensorsMeasurements.SensorsMeasurementsResponseModel;
import org.springframework.stereotype.Component;

@Component
public class SensorsMeasurementsPresenterImpl implements SensorsMeasurementsPresenter {
    @Override
    public SensorsMeasurementsResponseModel prepareSuccessView(SensorsMeasurementsResponseModel response){return response;}

    @Override
    public SensorsMeasurementsSensorNotFoundException prepareSensorNotFoundView(){throw new SensorsMeasurementsSensorNotFoundException();}

    @Override
    public SensorsMeasurementsTypeNotFoundException prepareTypeNotFoundView(){throw new SensorsMeasurementsTypeNotFoundException();}
}
