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
    @Autowired
    private SensorsMeasurementsDS sensorsMeasurementsDS;
    private SensorsDS sensorsDS;
    private MeasurementsTypeDS measurementsTypeDS;

    private SensorsMeasurementsPresenter sensorsMeasurementsPresenter;
    private SensorsPresenter sensorsPresenter;
    private MeasurementsTypePresenter measurementsTypePresenter;

    private final SensorsMeasurementsFactory sensorsMeasurementsFactory;

    public SensorsMeasurementsServiceImpl(SensorsMeasurementsDS sensorsMeasurementsDS, SensorsDS sensorsDS, MeasurementsTypeDS measurementsTypeDS, SensorsMeasurementsPresenter sensorsMeasurementsPresenter, SensorsPresenter sensorsPresenter, MeasurementsTypePresenter measurementsTypePresenter, SensorsMeasurementsFactory sensorsMeasurementsFactory) {
        this.sensorsMeasurementsDS = sensorsMeasurementsDS;
        this.sensorsDS = sensorsDS;
        this.measurementsTypeDS = measurementsTypeDS;
        this.sensorsMeasurementsPresenter = sensorsMeasurementsPresenter;
        this.sensorsPresenter = sensorsPresenter;
        this.measurementsTypePresenter = measurementsTypePresenter;
        this.sensorsMeasurementsFactory = sensorsMeasurementsFactory;
    }

    @Override
    public SensorsMeasurementsResponseModel create(Integer sensorId, SensorsMeasurementsRequesBody data){
        if (sensorsDS.existsBySensorId(sensorId)) throw sensorsPresenter.prepareSensorsNotFoundView();

        for (SensorsMeasurementsRequesBodyList el : data.getSensors_measurements()){
            if (!sensorsDS.existsByTypeId(el.getType_id())) throw measurementsTypePresenter.prepareMeasurementsTypeNotFoundView();
        }

        List<SensorsMeasurements> sensorsMeasurements = sensorsMeasurementsFactory.create(sensorId, data);

        SensorsMeasurementsDSRequestModel dsRequest = new SensorsMeasurementsDSRequestModel(sensorsMeasurements);

        List<SensorsMeasurementsEntity> dsResponse = sensorsMeasurementsDS.create(dsRequest);

        return sensorsMeasurementsPresenter.prepareSuccessView(makePostResponse(dsResponse));
    }

    @Override
    public void delete(Integer sensorId, SensorsMeasurementsRequestBodyDelete measurementsType){
        if (sensorsDS.existsBySensorId(sensorId)) throw sensorsPresenter.prepareSensorsNotFoundView();

        for (Integer typeId : measurementsType.getMeasurements_type()){
            if (!measurementsTypeDS.existsByTypeId(typeId)) throw measurementsTypePresenter.prepareMeasurementsTypeNotFoundView();
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
