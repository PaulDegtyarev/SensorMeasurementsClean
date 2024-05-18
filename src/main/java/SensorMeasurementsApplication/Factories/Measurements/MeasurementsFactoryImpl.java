package SensorMeasurementsApplication.Factories.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Delete.MeasurementsDelete;
import SensorMeasurementsApplication.CustomModels.Measurements.Delete.MeasurementsDeleteImpl;
import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.CustomModels.Measurements.MeasurementsImpl;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBodyList;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class MeasurementsFactoryImpl implements MeasurementsFactory{
    @Override
    public List<Measurements> create(MeasurementsRequestBodyList data){
        List<Measurements> models = new ArrayList<>();
        for (MeasurementsRequestBody el : data.getMeasurements()){
            MeasurementsImpl model = new MeasurementsImpl(el.getMeasurement_value(), el.getMeasurement_ts(), el.getSensor_inventory_number(), el.getMeasurement_type());
            models.add(model);
        }

        return models;
    }

    @Override
    public MeasurementsDelete createDelete(String from, String to){return new MeasurementsDeleteImpl(Timestamp.valueOf(from), Timestamp.valueOf(to));}
}
