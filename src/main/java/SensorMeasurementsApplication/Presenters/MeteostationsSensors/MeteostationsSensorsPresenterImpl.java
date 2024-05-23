package SensorMeasurementsApplication.Presenters.MeteostationsSensors;

import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsConflictException;
import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsInvNumbNotFoundException;
import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsSensorNotFoundException;
import SensorMeasurementsApplication.Exceptions.MeteostationsSensors.MeteostationsSensorsStationNotFoundException;
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
    public MeteostationsSensorsInvNumbNotFoundException prepareInventoryNumberNotFoundView(){throw new MeteostationsSensorsInvNumbNotFoundException();}

    @Override
    public MeteostationsSensorsStationNotFoundException prepareStationNotFoundView(){throw new MeteostationsSensorsStationNotFoundException();}

    @Override
    public MeteostationsSensorsSensorNotFoundException prepareSensorNotFoundView(){throw new MeteostationsSensorsSensorNotFoundException();}
}
