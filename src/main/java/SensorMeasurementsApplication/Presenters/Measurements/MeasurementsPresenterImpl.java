package SensorMeasurementsApplication.Presenters.Measurements;

import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsPresenterImpl implements MeasurementsPresenter{
    @Override
    public MeasurementsPostResponseModel prepareSuccessPostView(MeasurementsPostResponseModel response){return response;}
}
