package SensorMeasurementsApplication.Services.MeasurementsTypes;

import SensorMeasurementsApplication.RequestBodies.MeasurementsTypesRequestBody.MeasurementsTypesRequestBody;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelGetAll;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelPost;

public interface MeasurementsTypeService {

    MeasurementsTypeResponseModelPost create(MeasurementsTypesRequestBody data);

    void delete(Integer typeId);


    void update(Integer typeId, MeasurementsTypesRequestBody data);

    MeasurementsTypeResponseModelGetAll getAll();
}
