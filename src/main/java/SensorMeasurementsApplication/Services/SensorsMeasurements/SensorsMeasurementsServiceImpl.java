package SensorMeasurementsApplication.Services.SensorsMeasurements;

import SensorMeasurementsApplication.CustomModels.SensorsMeasurements.SensorsMeasurements;
import SensorMeasurementsApplication.DataStores.MeasurementsTypes.MeasurementsTypeDS;
import SensorMeasurementsApplication.DataStores.Sensors.SensorsDS;
import SensorMeasurementsApplication.DataStores.SensorsMeasurements.SensorsMeasurementsDS;
import SensorMeasurementsApplication.Factories.SensorsMeasurements.SensorsMeasurementsFactory;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import SensorMeasurementsApplication.Presenters.MeasurementsTypes.MeasurementsTypePresenter;
import SensorMeasurementsApplication.Presenters.Sensors.SensorsPresenter;
import SensorMeasurementsApplication.Presenters.SensorsMeasurements.SensorsMeasurementsPresenter;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Delete.SensorsMeasurementsRequestBodyDelete;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Post.SensorsMeasurementsRequesBody;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Post.SensorsMeasurementsRequesBodyList;
import SensorMeasurementsApplication.RequestDataStoreModels.SensorsMeasurements.SensorsMeasurementsDSRequestModel;
import SensorMeasurementsApplication.Responses.SensorsMeasurements.SensorsMeasurementsResponseList;
import SensorMeasurementsApplication.Responses.SensorsMeasurements.SensorsMeasurementsResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Service
public class SensorsMeasurementsServiceImpl implements SensorsMeasurementsService {
    private SensorsMeasurementsDS sensorsMeasurementsDS;
    private SensorsMeasurementsPresenter sensorsMeasurementsPresenter;
    private SensorsMeasurementsFactory sensorsMeasurementsFactory;

    @Autowired
    public SensorsMeasurementsServiceImpl(SensorsMeasurementsDS sensorsMeasurementsDS, SensorsMeasurementsPresenter sensorsMeasurementsPresenter, SensorsMeasurementsFactory sensorsMeasurementsFactory) {
        this.sensorsMeasurementsDS = sensorsMeasurementsDS;
        this.sensorsMeasurementsPresenter = sensorsMeasurementsPresenter;
        this.sensorsMeasurementsFactory = sensorsMeasurementsFactory;
    }


    @Override
    public SensorsMeasurementsResponseModel create(Integer sensorId, SensorsMeasurementsRequesBody data){
        if (!sensorsMeasurementsDS.existsBySensorId(sensorId)) throw sensorsMeasurementsPresenter.prepareSensorNotFoundView();

        for (SensorsMeasurementsRequesBodyList el : data.getSensors_measurements()){
            if (!sensorsMeasurementsDS.existsByTypeId(el.getType_id())) throw sensorsMeasurementsPresenter.prepareTypeNotFoundView();
        }

        List<SensorsMeasurements> sensorsMeasurements = sensorsMeasurementsFactory.create(sensorId, data);

        SensorsMeasurementsDSRequestModel dsRequest = new SensorsMeasurementsDSRequestModel(sensorsMeasurements);

        List<SensorsMeasurementsEntity> dsResponse = sensorsMeasurementsDS.create(dsRequest);

        return sensorsMeasurementsPresenter.prepareSuccessView(makePostResponse(dsResponse));
    }

    @Override
    public void delete(Integer sensorId, SensorsMeasurementsRequestBodyDelete measurementsType){
        if (sensorsMeasurementsDS.existsBySensorId(sensorId)) throw sensorsMeasurementsPresenter.prepareSensorNotFoundView();

        for (Integer typeId : measurementsType.getMeasurements_type()){
            if (!sensorsMeasurementsDS.existsByTypeId(typeId)) throw sensorsMeasurementsPresenter.prepareTypeNotFoundView();
        }

        sensorsMeasurementsDS.delete(sensorId, measurementsType);
    }

    private SensorsMeasurementsResponseModel makePostResponse(List<SensorsMeasurementsEntity> dsResponse){
        List<SensorsMeasurementsResponseList> responseList = new ArrayList<>();

        for (SensorsMeasurementsEntity el : dsResponse){
            SensorsMeasurementsResponseList responseEl = new SensorsMeasurementsResponseList(el.getSensorsMeasurementsKey().getSensorId(), el.getSensor().getSensorName(), el.getSensorsMeasurementsKey().getTypeId(), el.getMeasurementsTypes().getTypeName(), el.getMeasurementsTypes().getTypeUnits(), el.getTypeFormula());
            responseList.add(responseEl);
        }
        return new SensorsMeasurementsResponseModel(responseList);
    }
}
