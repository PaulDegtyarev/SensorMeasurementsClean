package SensorMeasurementsApplication.Presenters.Measurements;

import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;

public interface MeasurementsPresenter {
    MeasurementsPostResponseModel prepareSuccessPostView(MeasurementsPostResponseModel response);
}
