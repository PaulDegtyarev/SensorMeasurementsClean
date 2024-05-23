package SensorMeasurementsApplication.DataStores.MeasurementsTypes;

import SensorMeasurementsApplication.Exceptions.MeasurementsTypes.MeasurementsTypeNotFoundException;
import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.JPARepository.MeasurementsTypeRepository;
import SensorMeasurementsApplication.RequestBodies.MeasurementsTypes.MeasurementsTypesRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.MeasurementsTypes.MeasurementsTypeDSRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeasurementsTypeDSImpl implements MeasurementsTypeDS {
    private MeasurementsTypeRepository measurementsTypeRepository;

    @Autowired
    public MeasurementsTypeDSImpl(MeasurementsTypeRepository measurementsTypeRepository) {
        this.measurementsTypeRepository = measurementsTypeRepository;
    }

    @Override
    public MeasurementsTypeEntity create(MeasurementsTypeDSRequestModel data){
        MeasurementsTypeEntity measurementsType = new MeasurementsTypeEntity(data.getTypeName(), data.getTypeUnits());
        measurementsTypeRepository.save(measurementsType);
        return measurementsType;
    }

    @Override
    public void delete(Integer typeId){
        MeasurementsTypeEntity measurementsType = measurementsTypeRepository.findById(typeId).orElseThrow(MeasurementsTypeNotFoundException::new);
        measurementsTypeRepository.delete(measurementsType);
    }

    @Override
    public void update(Integer typeId, MeasurementsTypesRequestBody data){
        MeasurementsTypeEntity measurementsType = measurementsTypeRepository.findById(typeId).orElseThrow(MeasurementsTypeNotFoundException::new);
        measurementsType.setTypeName(data.getType_name());
        measurementsType.setTypeUnits(data.getType_units());
        measurementsTypeRepository.save(measurementsType);
    }

    @Override
    public List<MeasurementsTypeEntity> getAll(){
        return measurementsTypeRepository.findAll();
    }

    @Override
    public boolean hasMeasurements(Integer typeId){
        MeasurementsTypeEntity measurementsType = measurementsTypeRepository.findById(typeId).orElseThrow(MeasurementsTypeNotFoundException::new);
        return !measurementsType.getMeasurements().isEmpty();
    }

    @Override
    public boolean existsByTypeName(String typeName){
        return measurementsTypeRepository.existsByTypeName(typeName);
    }

    @Override
    public boolean existsByTypeId(Integer typeId){return measurementsTypeRepository.existsByTypeId(typeId);}
}
