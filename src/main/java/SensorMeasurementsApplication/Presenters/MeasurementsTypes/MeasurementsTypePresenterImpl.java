package SensorMeasurementsApplication.Presenters.MeasurementsTypes;

import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeConflictException;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelPost;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsTypePresenterImpl implements MeasurementsTypePresenter {
    @Override
    public MeasurementsTypeResponseModelPost prepareSuccessView(MeasurementsTypeResponseModelPost response){return response;}
    @Override
    public MeasurementsTypeConflictException prepareMeasurementsTypeConflictView(){throw new MeasurementsTypeConflictException();}
}
