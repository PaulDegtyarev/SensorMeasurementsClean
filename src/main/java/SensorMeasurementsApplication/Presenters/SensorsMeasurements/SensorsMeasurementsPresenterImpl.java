package SensorMeasurementsApplication.Presenters.SensorsMeasurements;

import SensorMeasurementsApplication.Responses.SensorsMeasurements.SensorsMeasurementsResponseModel;
import org.springframework.stereotype.Component;

@Component
public class SensorsMeasurementsPresenterImpl implements SensorsMeasurementsPresenter {
    @Override
    public SensorsMeasurementsResponseModel prepareSuccessView(SensorsMeasurementsResponseModel response){return response;}
}
