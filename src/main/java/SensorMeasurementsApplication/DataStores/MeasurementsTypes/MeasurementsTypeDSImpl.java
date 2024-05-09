package SensorMeasurementsApplication.DataStores.MeasurementsTypes;

import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.JPARepository.MeasurementsTypeRepository;
import SensorMeasurementsApplication.RequestDataStoreModels.MeasurementsTypes.MeasurementsTypeDSRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeasurementsTypeDSImpl implements MeasurementsTypeDS {
    @Autowired
    private final MeasurementsTypeRepository measurementsTypeRepository;

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
    public boolean existsByTypeName(String typeName){
        return measurementsTypeRepository.existsByTypeName(typeName);
    }
}
