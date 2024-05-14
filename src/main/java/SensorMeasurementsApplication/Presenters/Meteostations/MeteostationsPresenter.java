package SensorMeasurementsApplication.Presenters.Meteostations;

import SensorMeasurementsApplication.Exceptions.Meteostations.MeteostationsConflictException;
import SensorMeasurementsApplication.Exceptions.Meteostations.MeteostationsNotFoundException;
import SensorMeasurementsApplication.Responses.Meteostations.MeteostationResponseModel;
import SensorMeasurementsApplication.Responses.Meteostations.WithSensors.MeteostationsWithSensorsReponseModel;

import java.util.List;

public interface MeteostationsPresenter
{
    MeteostationResponseModel prepareSuccessPostView(MeteostationResponseModel response);

    List<MeteostationResponseModel> prepareSuccessGetAllView(List<MeteostationResponseModel> response);

    MeteostationsWithSensorsReponseModel prepareSuccessWithSensorsView(MeteostationsWithSensorsReponseModel response);

    MeteostationsConflictException prepareConflictView();

    MeteostationsNotFoundException prepareNotFoundView();
}
