package SensorMeasurementsApplication.Presenters.MeteostationsSensors;

import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsConflictException;
import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsNotFoundException;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Get.MeteostationsSensorsGetResponseModel;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MeteostationsSensorsPostResponse;
import org.springframework.stereotype.Component;

@Component
public class MeteostationsSensorsPresenterImpl implements MeteostationsSensorsPresenter{
    @Override
    public MeteostationsSensorsPostResponse prepareSuccessPostView(MeteostationsSensorsPostResponse response){return response;}

    @Override
    public MeteostationsSensorsConflictException prepareConflictView(){throw new MeteostationsSensorsConflictException();}

    @Override
    public MeteostationsSensorsGetResponseModel prepareSuccsessGetView(MeteostationsSensorsGetResponseModel response){return response;}

    @Override
    public MeteostationsSensorsNotFoundException prepareNotFoundView(){throw new MeteostationsSensorsNotFoundException();}
}
