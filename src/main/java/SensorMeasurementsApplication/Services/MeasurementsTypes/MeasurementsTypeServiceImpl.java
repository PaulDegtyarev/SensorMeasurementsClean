package SensorMeasurementsApplication.Services.MeasurementsTypes;

import SensorMeasurementsApplication.CustomModels.MeasurementsTypes.MeasurementsType;
import SensorMeasurementsApplication.DataStores.MeasurementsTypes.MeasurementsTypeDS;
import SensorMeasurementsApplication.Factories.MeasurementsTypes.MeasurementsTypeFactory;
import SensorMeasurementsApplication.JPAEntities.MeasurementsTypeEntity;
import SensorMeasurementsApplication.Presenters.MeasurementsTypes.MeasurementsTypePresenter;
import SensorMeasurementsApplication.RequestBodies.MeasurementsTypes.MeasurementsTypesRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.MeasurementsTypes.MeasurementsTypeDSRequestModel;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelGetAll;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementsTypeServiceImpl implements MeasurementsTypeService{
    private MeasurementsTypeDS measurementsTypeDS;
    private MeasurementsTypeFactory measurementsTypeFactory;
    private MeasurementsTypePresenter measurementsTypePresenter;

    @Autowired
    public MeasurementsTypeServiceImpl(MeasurementsTypeDS measurementsTypeDS, MeasurementsTypeFactory measurementsTypeFactory, MeasurementsTypePresenter measurementsTypePresenter) {
        this.measurementsTypeDS = measurementsTypeDS;
        this.measurementsTypeFactory = measurementsTypeFactory;
        this.measurementsTypePresenter = measurementsTypePresenter;
    }

    @Override
    public MeasurementsTypeResponseModelPost create(MeasurementsTypesRequestBody data){
        if (measurementsTypeDS.existsByTypeName(data.getType_name())) throw measurementsTypePresenter.prepareMeasurementsTypeConflictView();
        if (data.getType_name().length() > 31 || data.getType_units().length() > 4) throw measurementsTypePresenter.prepareMeasurementsTypeBadRequestView();

        MeasurementsType measurementsType = measurementsTypeFactory.create(data);

        MeasurementsTypeDSRequestModel dsRequestModel = new MeasurementsTypeDSRequestModel(measurementsType.getTypeName(), measurementsType.getTypeUnits());

        MeasurementsTypeEntity dsResponse = measurementsTypeDS.create(dsRequestModel);

        return measurementsTypePresenter.prepareSuccessView(makePostResponse(dsResponse));
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
        if (data.getType_name().length() > 31 || data.getType_units().length() > 4) throw measurementsTypePresenter.prepareMeasurementsTypeBadRequestView();

        measurementsTypeDS.update(typeId, data);
    }

    @Override
    public MeasurementsTypeResponseModelGetAll getAll(){
        return measurementsTypePresenter.prepareSuccessGetAllView(makeAllResponse(measurementsTypeDS.getAll()));
    }

    private static MeasurementsTypeResponseModelGetAll makeAllResponse(List<MeasurementsTypeEntity> measurementsTypesList){
        List<MeasurementsTypeResponseModelPost> responseList = new ArrayList<>();
        for (MeasurementsTypeEntity type : measurementsTypesList){
            MeasurementsTypeResponseModelPost el = new MeasurementsTypeResponseModelPost(type.getTypeId(), type.getTypeName(), type.getTypeUnits());
            responseList.add(el);
        }

        return new MeasurementsTypeResponseModelGetAll(responseList);
    }

    private static MeasurementsTypeResponseModelPost makePostResponse(MeasurementsTypeEntity dsResponse){
        return new MeasurementsTypeResponseModelPost(dsResponse.getTypeId(), dsResponse.getTypeName(), dsResponse.getTypeUnits());
    }
}
