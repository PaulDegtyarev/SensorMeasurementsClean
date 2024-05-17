package SensorMeasurementsApplication.DataStores.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsKey;
import SensorMeasurementsApplication.JPARepository.MeasurementsRepository;
import SensorMeasurementsApplication.JPARepository.MeasurementsTypeRepository;
import SensorMeasurementsApplication.JPARepository.MeteostationsSensorsRepository;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Component
public class MeasurementsDSImpl implements MeasurementsDS{
    @Autowired
    private MeasurementsRepository measurementsRepository;
    private MeasurementsTypeRepository measurementsTypeRepository;
    private MeteostationsSensorsRepository meteostationsSensorsRepository;

    public MeasurementsDSImpl(MeasurementsRepository measurementsRepository, MeasurementsTypeRepository measurementsTypeRepository, MeteostationsSensorsRepository meteostationsSensorsRepository) {
        this.measurementsRepository = measurementsRepository;
        this.measurementsTypeRepository = measurementsTypeRepository;
        this.meteostationsSensorsRepository = meteostationsSensorsRepository;
    }

    @Override
    public List<MeasurementsEntity> create(MeasurementsDSRequesModel dsRequest){
        List<MeasurementsEntity> dsResponse = new ArrayList<>();

        for (Measurements el : dsRequest.getMeasurements()){
            MeasurementsKey key = new MeasurementsKey(el.getMeasurementsValue(), el.getMeasurementType(), el.getMeasurementTS(), el.getSensorInventoryNumber());
            MeasurementsEntity measurement = new MeasurementsEntity(key);
            measurementsRepository.save(measurement);
            dsResponse.add(measurement);
        }

        return dsResponse;
    }

    @Override
    public List<MeasurementsEntity> getByParam(Integer sensorInventoryNumber){return measurementsRepository.findAllByMeasurementsKey_SensorInventoryNumber(sensorInventoryNumber);}

    @Override
    public List<MeasurementsEntity> all() {
        return measurementsRepository.findAll();}

    @Override
    public boolean existsByTypeId(Integer typeId){return measurementsTypeRepository.existsByTypeId(typeId);}

    @Override
    public boolean existsBySensorInventoryNumber(Integer sensorInventoryNumber){return meteostationsSensorsRepository.existsBySensorInventoryNumber(sensorInventoryNumber);}

    @Override
    public boolean existsByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber){return measurementsRepository.existsByMeasurementsKey_SensorInventoryNumber(sensorInventoryNumber);}
}
