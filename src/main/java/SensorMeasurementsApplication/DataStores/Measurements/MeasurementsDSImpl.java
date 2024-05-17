package SensorMeasurementsApplication.DataStores.Measurements;

import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsKey;
import SensorMeasurementsApplication.JPARepository.MeasurementsRepository;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsDSImpl implements MeasurementsDS{
    @Autowired
    private MeasurementsRepository measurementsRepository;

    public MeasurementsDSImpl(MeasurementsRepository measurementsRepository) {
        this.measurementsRepository = measurementsRepository;
    }

    @Override
    public MeasurementsEntity create(MeasurementsDSRequesModel dsRequest){
        MeasurementsKey key = new MeasurementsKey(dsRequest.getMeasurementsValue(), dsRequest.getMeasurementType(), dsRequest.getMeasurementTS(), dsRequest.getSensorInventoryNumber());
        MeasurementsEntity measurement = new MeasurementsEntity(key);
        measurementsRepository.save(measurement);
        return measurement;
    }
}
