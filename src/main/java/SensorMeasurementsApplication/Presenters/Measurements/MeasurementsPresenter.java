package SensorMeasurementsApplication.Presenters.Measurements;

import SensorMeasurementsApplication.Exceptions.Measurements.MeasurementsBadRequestException;
import SensorMeasurementsApplication.Exceptions.Measurements.MeasurementsNotFoundException;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;

public interface MeasurementsPresenter {
    MeasurementsPostResponseModel prepareSuccessPostView(MeasurementsPostResponseModel response);

    MeasurementsNotFoundException prepareNotFoundView();

    MeasurementsBadRequestException prepareBadRequestView();
}
