package SensorMeasurementsApplication.Presenters.Meteostations;

import SensorMeasurementsApplication.Exceptions.Meteostations.MeteostationsConflictException;
import SensorMeasurementsApplication.Exceptions.Meteostations.MeteostationsNotFoundException;
import SensorMeasurementsApplication.Responses.Meteostations.MeteostationResponseModel;
import SensorMeasurementsApplication.Responses.Meteostations.WithSensors.MeteostationsWithSensorsReponseModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeteostationsPresenterImpl implements MeteostationsPresenter {
    @Override
    public MeteostationResponseModel prepareSuccessPostView(MeteostationResponseModel response){return response;}

    @Override
    public List<MeteostationResponseModel> prepareSuccessGetAllView(List<MeteostationResponseModel> response){return response;}

    @Override
    public MeteostationsWithSensorsReponseModel prepareSuccessWithSensorsView(MeteostationsWithSensorsReponseModel response){return response;}

    @Override
    public MeteostationsConflictException prepareConflictView(){throw new MeteostationsConflictException();}

    @Override
    public MeteostationsNotFoundException prepareNotFoundView(){throw new MeteostationsNotFoundException();}
}
