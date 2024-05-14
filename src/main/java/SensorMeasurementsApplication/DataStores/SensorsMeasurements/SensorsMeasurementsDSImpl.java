package SensorMeasurementsApplication.DataStores.SensorsMeasurements;

import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurements;
import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeNotFoundException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsNotFoundException;
import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsKey;
import SensorMeasurementsApplication.JPARepository.MeasurementsTypeRepository;
import SensorMeasurementsApplication.JPARepository.SensorsMeasurementsRepository;
import SensorMeasurementsApplication.JPARepository.SensorsRepository;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Delete.SensorsMeasurementsRequestBodyDelete;
import SensorMeasurementsApplication.RequestDataStoreModels.SensorsMeasurements.SensorsMeasurementsDSRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Component
public class SensorsMeasurementsDSImpl implements SensorsMeasurementsDS {
    @Autowired
    private SensorsMeasurementsRepository sensorsMeasurementsRepository;
    private SensorsRepository sensorsRepository;
    private MeasurementsTypeRepository measurementsTypeRepository;

    public SensorsMeasurementsDSImpl(SensorsMeasurementsRepository sensorsMeasurementsRepository, SensorsRepository sensorsRepository, MeasurementsTypeRepository measurementsTypeRepository) {
        this.sensorsMeasurementsRepository = sensorsMeasurementsRepository;
        this.sensorsRepository = sensorsRepository;
        this.measurementsTypeRepository = measurementsTypeRepository;
    }

    @Override
    public List<SensorsMeasurementsEntity> create(SensorsMeasurementsDSRequestModel dsRequest){

        List<SensorsMeasurementsEntity> dsResponse = new ArrayList<>();

        for (SensorsMeasurements el : dsRequest.getSensorsMeasurements()){
            SensorsEntity sensor = sensorsRepository.findById(el.getSensorId()).orElseThrow(SensorsNotFoundException::new);
            MeasurementsTypeEntity measurementType = measurementsTypeRepository.findById(el.getTypeId()).orElseThrow(MeasurementsTypeNotFoundException::new);

            SensorsMeasurementsKey key = new SensorsMeasurementsKey(sensor.getSensorId(), measurementType.getTypeId());
            SensorsMeasurementsEntity sensorsMeasurementsEntity = new SensorsMeasurementsEntity(key, el.getTypeFormula());
            sensorsMeasurementsEntity.setSensor(sensor);
            sensorsMeasurementsEntity.setMeasurementsTypes(measurementType);

            sensorsMeasurementsRepository.save(sensorsMeasurementsEntity);

            dsResponse.add(sensorsMeasurementsEntity);
        }
        return dsResponse;
    }

    @Override
    public void delete(Integer sensorId, SensorsMeasurementsRequestBodyDelete measurementsType){
        for (Integer typeId : measurementsType.getMeasurements_type()){
            SensorsMeasurementsKey key = new SensorsMeasurementsKey(sensorId, typeId);

            SensorsMeasurementsEntity sensorsMeasurements = sensorsMeasurementsRepository.findById(key).orElseThrow(SensorsNotFoundException::new);
            sensorsMeasurementsRepository.delete(sensorsMeasurements);
        }
    }
}
