package SensorMeasurementsApplication.Presenters.MeasurementsTypes;

import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeConflictException;
import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeNotFoundException;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelGetAll;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelPost;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsTypePresenterImpl implements MeasurementsTypePresenter {
    @Override
    public MeasurementsTypeResponseModelPost prepareSuccessView(MeasurementsTypeResponseModelPost response){return response;}

    @Override
    public MeasurementsTypeConflictException prepareMeasurementsTypeConflictView(){throw new MeasurementsTypeConflictException();}

    @Override
    public MeasurementsTypeNotFoundException prepareMeasurementsTypeNotFoundView(){throw new MeasurementsTypeNotFoundException();}

    @Override
    public MeasurementsTypeResponseModelGetAll prepareSuccessGetAllView(MeasurementsTypeResponseModelGetAll response){return response;}
}
