package SensorMeasurementsApplication.Factories.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Delete.MeasurementsDelete;
import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBodyList;

import java.util.List;

public interface MeasurementsFactory {
    List<Measurements> create(MeasurementsRequestBodyList data);

    MeasurementsDelete createDelete(String from, String to);
}
