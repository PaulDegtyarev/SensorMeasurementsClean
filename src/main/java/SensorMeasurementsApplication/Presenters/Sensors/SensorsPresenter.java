package SensorMeasurementsApplication.Presenters.Sensors;

import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeNotFoundException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsConfictException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsHasMeasurementsException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsNotFoundException;
import SensorMeasurementsApplication.Responses.Sensors.GetAll.SensorsResponseModelGetAll;
import SensorMeasurementsApplication.Responses.Sensors.GetTypes.SensorsResponseModelGetTypes;
import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsResponseModelPost;

public interface SensorsPresenter {
    SensorsResponseModelPost prepareSuccessView(SensorsResponseModelPost response);

    MeasurementsTypeNotFoundException prepareMeasurementTypeNotFoundView();

    SensorsConfictException prepareSensorsConflictView();

    SensorsNotFoundException prepareSensorsNotFoundView();

    SensorsHasMeasurementsException prepareSensorsHasMeasurementsView();

    SensorsResponseModelGetAll prepareSuccessGetAllView(SensorsResponseModelGetAll response);

    SensorsResponseModelGetTypes prepareSuccessGetTypeView(SensorsResponseModelGetTypes response);
}
