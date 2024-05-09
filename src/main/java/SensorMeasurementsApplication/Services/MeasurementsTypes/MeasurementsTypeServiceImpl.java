package SensorMeasurementsApplication.Services.MeasurementsTypes;

import SensorMeasurementsApplication.CustomModels.MeasurementsTypes.MeasurementsType;
import SensorMeasurementsApplication.DataStores.MeasurementsTypes.MeasurementsTypeDS;
import SensorMeasurementsApplication.Factories.MeasurementsTypes.MeasurementsTypeFactory;
import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.Presenters.MeasurementsTypes.MeasurementsTypePresenter;
import SensorMeasurementsApplication.RequestBodies.MeasurementsTypesRequestBody.MeasurementsTypesRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.MeasurementsTypes.MeasurementsTypeDSRequestModel;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelGetAll;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementsTypeServiceImpl implements MeasurementsTypeService{
    @Autowired
    private final MeasurementsTypeDS measurementsTypeDS;
    private final MeasurementsTypeFactory measurementsTypeFactory;
    private final MeasurementsTypePresenter measurementsTypePresenter;

    public MeasurementsTypeServiceImpl(MeasurementsTypeDS measurementsTypeDS, MeasurementsTypeFactory measurementsTypeFactory, MeasurementsTypePresenter measurementsTypePresenter) {
        this.measurementsTypeDS = measurementsTypeDS;
        this.measurementsTypeFactory = measurementsTypeFactory;
        this.measurementsTypePresenter = measurementsTypePresenter;
    }

    @Override
    public MeasurementsTypeResponseModelPost create(MeasurementsTypesRequestBody data){
        if (measurementsTypeDS.existsByTypeName(data.getType_name())) throw measurementsTypePresenter.prepareMeasurementsTypeConflictView();

        MeasurementsType measurementsType = measurementsTypeFactory.create(data);

        MeasurementsTypeDSRequestModel dsRequestModel = new MeasurementsTypeDSRequestModel(measurementsType.getTypeName(), measurementsType.getTypeUnits());

        MeasurementsTypeEntity dsResponse = measurementsTypeDS.create(dsRequestModel);

        MeasurementsTypeResponseModelPost response = new MeasurementsTypeResponseModelPost(dsResponse.getTypeId(), dsResponse.getTypeName(), dsResponse.getTypeUnits());

        return measurementsTypePresenter.prepareSuccessView(response);
    }

    @Override
    public void delete(Integer typeId){
        if (!measurementsTypeDS.existsByTypeId(typeId)) throw measurementsTypePresenter.prepareMeasurementsTypeNotFoundView();
        if (measurementsTypeDS.hasMeasurements(typeId)) throw measurementsTypePresenter.prepareMeasurementsTypeConflictView();
        measurementsTypeDS.delete(typeId);
    }

    @Override
    public void update(Integer typeId, MeasurementsTypesRequestBody data){
        if (!measurementsTypeDS.existsByTypeId(typeId)) throw measurementsTypePresenter.prepareMeasurementsTypeNotFoundView();
        measurementsTypeDS.update(typeId, data);
    }

    @Override
    public MeasurementsTypeResponseModelGetAll getAll(){
        List<MeasurementsTypeEntity> measurementsTypesList = measurementsTypeDS.getAll();

        List<MeasurementsTypeResponseModelPost> responseList = new ArrayList<>();
        for (MeasurementsTypeEntity type : measurementsTypesList){
            MeasurementsTypeResponseModelPost el = new MeasurementsTypeResponseModelPost(type.getTypeId(), type.getTypeName(), type.getTypeUnits());
            responseList.add(el);
        }

        MeasurementsTypeResponseModelGetAll response = new MeasurementsTypeResponseModelGetAll(responseList);
        return measurementsTypePresenter.prepareSuccessGetAllView(response);
    }
}
