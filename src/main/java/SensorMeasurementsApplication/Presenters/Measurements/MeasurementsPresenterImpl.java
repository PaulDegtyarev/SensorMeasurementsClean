package SensorMeasurementsApplication.Presenters.Measurements;

import SensorMeasurementsApplication.Exceptions.Measurements.MeasurementsBadRequestException;
import SensorMeasurementsApplication.Exceptions.Measurements.MeasurementsNotFoundException;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsPresenterImpl implements MeasurementsPresenter{
    @Override
    public MeasurementsPostResponseModel prepareSuccessPostView(MeasurementsPostResponseModel response){return response;}

    @Override
    public MeasurementsNotFoundException prepareNotFoundView(){throw new MeasurementsNotFoundException();}

    @Override
    public MeasurementsBadRequestException prepareBadRequestView(){throw new MeasurementsBadRequestException();}

}
