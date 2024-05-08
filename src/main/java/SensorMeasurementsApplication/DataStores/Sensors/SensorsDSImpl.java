package SensorMeasurementsApplication.DataStores.Sensors;

import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeNotFoundException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsNotFoundException;
import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsKey;
import SensorMeasurementsApplication.JPARepository.MeasurementsTypeRepository;
import SensorMeasurementsApplication.JPARepository.SensorsMeasurementsRepository;
import SensorMeasurementsApplication.JPARepository.SensorsRepository;
import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsMeasurementsRequestBodyList;
import SensorMeasurementsApplication.RequestDataStoreModels.Sensors.SensorsRequestDSModel;
import SensorMeasurementsApplication.ResponseDataStoreModels.Sensors.SensorsDSResponsePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.System.out;

@Component
public class SensorsDSImpl implements SensorsDS{
    @Autowired
    private final SensorsRepository sensorsRepository;
    private final SensorsMeasurementsRepository sensorsMeasurementsRepository;
    private final MeasurementsTypeRepository measurementsTypeRepository;

    public SensorsDSImpl(SensorsRepository sensorsRepository, SensorsMeasurementsRepository sensorsMeasurementsRepository, MeasurementsTypeRepository measurementsTypeRepository) {
        this.sensorsRepository = sensorsRepository;
        this.sensorsMeasurementsRepository = sensorsMeasurementsRepository;
        this.measurementsTypeRepository = measurementsTypeRepository;
    }

    @Override
    public SensorsDSResponsePost save(SensorsRequestDSModel data){

        SensorsEntity sensor = new SensorsEntity(data.getSensorName());
        sensorsRepository.save(sensor);

        List<SensorsMeasurementsEntity> sensorsMeasurementsEntityList = new ArrayList<>();
        for (SensorsMeasurementsRequestBodyList el : data.getSensorsMeasurements()){
            MeasurementsTypeEntity type = measurementsTypeRepository.findById(el.getType_id()).orElseThrow(MeasurementsTypeNotFoundException::new);

            SensorsMeasurementsKey key = new SensorsMeasurementsKey(sensor.getSensorId(), type.getTypeId());

            SensorsMeasurementsEntity sensorsMeasurementsEntity = new SensorsMeasurementsEntity(key, el.getType_formula());
            sensorsMeasurementsEntity.setMeasurementsTypes(type);

            sensorsMeasurementsRepository.save(sensorsMeasurementsEntity);

            sensorsMeasurementsEntityList.add(sensorsMeasurementsEntity);
        }

        sensor.setSensorsMeasurements(sensorsMeasurementsEntityList);
        return new SensorsDSResponsePost(sensor, sensor.getSensorsMeasurements());
    }

    @Override
    public void delete(Integer sensorId){
        SensorsEntity sensor = sensorsRepository.findById(sensorId).orElseThrow(SensorsNotFoundException::new);
        for (SensorsMeasurementsEntity sensorsMeasurements : sensor.getSensorsMeasurements()){
            sensorsMeasurementsRepository.delete(sensorsMeasurements);
        }
        sensorsRepository.delete(sensor);
    }

    @Override
    public void update(Integer sensorId, String sensorName){
        SensorsEntity sensor = sensorsRepository.findById(sensorId).orElseThrow(SensorsNotFoundException::new);
        sensor.setSensorName(sensorName);
        sensorsRepository.save(sensor);
    }

    @Override
    public List<SensorsEntity> all(){
        return sensorsRepository.findAll();
    }

    @Override
    public SensorsDSResponsePost one(Integer sensorId){
        SensorsEntity sensor = sensorsRepository.findById(sensorId).orElseThrow(SensorsNotFoundException::new);
        return new SensorsDSResponsePost(sensor, sensor.getSensorsMeasurements());
    }

    @Override
    public boolean existsByTypeId(Integer typeId){
        return measurementsTypeRepository.existsByTypeId(typeId);
    }

    @Override
    public boolean existsBySensorName(String sensorName){
        return sensorsRepository.existsBySensorName(sensorName);
    }

    @Override
    public boolean hasMeasurements(Integer sensorId){
        SensorsEntity sensor = sensorsRepository.findById(sensorId).orElseThrow(SensorsNotFoundException::new);
        return sensor.getMeteostationsSensors().isEmpty();
    }

    @Override
    public boolean existsBySensorId(Integer sensorId){return !sensorsRepository.existsBySensorId(sensorId);}
}
