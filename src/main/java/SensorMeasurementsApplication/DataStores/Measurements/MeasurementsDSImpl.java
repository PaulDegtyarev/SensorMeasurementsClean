package SensorMeasurementsApplication.DataStores.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurements;
import SensorMeasurementsApplication.Exceptions.Meteostations.MeteostationsNotFoundException;
import SensorMeasurementsApplication.Exceptions.Sensors.SensorsNotFoundException;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsKey;
import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import SensorMeasurementsApplication.JPARepository.*;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequestModelDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Component
public class MeasurementsDSImpl implements MeasurementsDS{
    private MeasurementsRepository measurementsRepository;
    private MeasurementsTypeRepository measurementsTypeRepository;
    private MeteostationsSensorsRepository meteostationsSensorsRepository;
    private MeteostationsRepository meteostationsRepository;
    private SensorsRepository sensorsRepository;

    @Autowired
    public MeasurementsDSImpl(MeasurementsRepository measurementsRepository, MeasurementsTypeRepository measurementsTypeRepository, MeteostationsSensorsRepository meteostationsSensorsRepository, MeteostationsRepository meteostationsRepository, SensorsRepository sensorsRepository) {
        this.measurementsRepository = measurementsRepository;
        this.measurementsTypeRepository = measurementsTypeRepository;
        this.meteostationsSensorsRepository = meteostationsSensorsRepository;
        this.meteostationsRepository = meteostationsRepository;
        this.sensorsRepository = sensorsRepository;
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
    public List<MeasurementsEntity> all() {return measurementsRepository.findAll();}

    @Override
    public void deleteByTime(MeasurementsDSRequestModelDelete dsRequest){
        List<MeasurementsEntity> measurements = measurementsRepository.findByMeasurementsKey_MeasurementTS(dsRequest.getFrom(), dsRequest.getTo());

        for (MeasurementsEntity measurement : measurements){
            measurementsRepository.delete(measurement);
        }
    }

    @Override
    public void deleteByStationId(Integer stationId){
        MeteostationsEntity meteostation = meteostationsRepository.findById(stationId).orElseThrow(MeteostationsNotFoundException::new);

        for (MeteostationsSensorsEntity meteostationsSensors : meteostation.getMeteostationsSensors()){
            for (MeasurementsEntity measurements : meteostationsSensors.getMeasurement()){
                measurementsRepository.delete(measurements);
            }
        }
    }

    @Override
    public void deleteBySensorId(Integer sensorId){
        SensorsEntity sensor = sensorsRepository.findById(sensorId).orElseThrow(SensorsNotFoundException::new);

        for (MeteostationsSensorsEntity meteostationsSensors : sensor.getMeteostationsSensors()){
            for (MeasurementsEntity measurement : meteostationsSensors.getMeasurement()){

                measurementsRepository.delete(measurement);
            }
        }
    }

    @Override
    public boolean existsByTypeId(Integer typeId){return measurementsTypeRepository.existsByTypeId(typeId);}

    @Override
    public boolean existsBySensorInventoryNumber(Integer sensorInventoryNumber){return meteostationsSensorsRepository.existsBySensorInventoryNumber(sensorInventoryNumber);}

    @Override
    public boolean existsByStationId(Integer stationId){return meteostationsSensorsRepository.existsByStationId(stationId);}
    @Override
    public boolean existsByMeasurementsKey_SensorInventoryNumber(Integer sensorInventoryNumber){return measurementsRepository.existsByMeasurementsKey_SensorInventoryNumber(sensorInventoryNumber);}

    @Override
    public boolean existsBySensorId(Integer sensorId){return meteostationsSensorsRepository.existsBySensorId(sensorId);}
}
