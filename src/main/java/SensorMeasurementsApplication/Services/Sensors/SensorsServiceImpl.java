package SensorMeasurementsApplication.Services.Sensors;

import SensorMeasurementsApplication.CustomModels.Sensors.Sensor;
import SensorMeasurementsApplication.DataStores.Sensors.SensorsDS;
import SensorMeasurementsApplication.Factories.Sensors.SensorsFactory;
import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsMeasurements.SensorsMeasurementsEntity;
import SensorMeasurementsApplication.Presenters.Sensors.SensorsPresenter;
import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsMeasurementsRequestBodyList;
import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsPostRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.Sensors.SensorsRequestDSModel;
import SensorMeasurementsApplication.ResponseDataStoreModels.Sensors.SensorsDSResponseGetTypes;
import SensorMeasurementsApplication.ResponseDataStoreModels.Sensors.SensorsDSResponsePost;
import SensorMeasurementsApplication.Responses.Sensors.GetAll.SensorsResponseModelGetAll;
import SensorMeasurementsApplication.Responses.Sensors.GetTypes.SensorsResponseModelGetTypes;
import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsMeasurementsResponseModelPostList;
import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsResponseModelPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SensorsServiceImpl implements SensorsService{
    @Autowired
    final SensorsDS sensorsDS;
    final SensorsFactory sensorsFactory;
    final SensorsPresenter sensorsPresenter;

    public SensorsServiceImpl(SensorsDS sensorsDS, SensorsFactory sensorsFactory, SensorsPresenter sensorsPresenter) {
        this.sensorsDS = sensorsDS;
        this.sensorsFactory = sensorsFactory;
        this.sensorsPresenter = sensorsPresenter;
    }

    @Override
    public SensorsResponseModelPost create(SensorsPostRequestBody data){
        if (sensorsDS.existsBySensorName(data.getSensor_name())) throw sensorsPresenter.prepareSensorsConflictView();
        for (SensorsMeasurementsRequestBodyList measurement : data.getSensors_measurements()){if (!sensorsDS.existsByTypeId(measurement.getType_id())) throw sensorsPresenter.prepareMeasurementTypeNotFoundView();}

        Sensor newSensor = sensorsFactory.create(data);

        SensorsRequestDSModel sensorsRequestDSModel = new SensorsRequestDSModel(newSensor.getSensorName(), newSensor.getSensorsMeasurements());
        SensorsDSResponsePost dsResponse = sensorsDS.save(sensorsRequestDSModel);

        SensorsResponseModelPost response = makeSensorsResponsePost(dsResponse);
        return sensorsPresenter.prepareSuccessView(response);
    }

    @Override
    public void delete(Integer sensorId) {
        if (sensorsDS.existsBySensorId(sensorId)) throw sensorsPresenter.prepareSensorsNotFoundView();
        if (!sensorsDS.hasMeasurements(sensorId)) throw sensorsPresenter.prepareSensorsHasMeasurementsView();
        sensorsDS.delete(sensorId);
    }

    @Override
    public void update(Integer sensorId, String sensorName){
        if (sensorsDS.existsBySensorId(sensorId)) throw sensorsPresenter.prepareSensorsNotFoundView();
        if (sensorsDS.existsBySensorName(sensorName)) throw sensorsPresenter.prepareSensorsConflictView();
        sensorsDS.update(sensorId, sensorName);
    }

    @Override
    public SensorsResponseModelGetAll all(){
        return sensorsPresenter.prepareSuccessGetAllView(makeSensorsResponseGetAll(sensorsDS.all()));
    }

    @Override
    public SensorsResponseModelPost one(Integer sensorId){
        if (sensorsDS.existsBySensorId(sensorId)) throw sensorsPresenter.prepareSensorsNotFoundView();

        SensorsDSResponsePost dsResponse = sensorsDS.one(sensorId);

        List<SensorsMeasurementsResponseModelPostList> responseList = new ArrayList<>();
        for (SensorsMeasurementsEntity measurements : dsResponse.getSensorsMeasurements()){
            SensorsMeasurementsResponseModelPostList list = new SensorsMeasurementsResponseModelPostList(measurements.getSensorsMeasurementsKey().getTypeId(), measurements.getMeasurementsTypes().getTypeName(), measurements.getMeasurementsTypes().getTypeUnits(), measurements.getTypeFormula());
            responseList.add(list);
        }
        SensorsResponseModelPost  response = new SensorsResponseModelPost(dsResponse.getSensor().getSensorId(), dsResponse.getSensor().getSensorName(), responseList);
        return sensorsPresenter.prepareSuccessView(response);
    }

    @Override
    public SensorsResponseModelGetTypes byType(Integer sensorId){
        if (sensorsDS.existsBySensorId(sensorId)) throw sensorsPresenter.prepareSensorsNotFoundView();

        List<SensorsDSResponseGetTypes> dsResponse = sensorsDS.getTypes(sensorId);

        List<SensorsMeasurementsResponseModelPostList> responseList = new ArrayList<>();
        for (SensorsDSResponseGetTypes el : dsResponse){
            SensorsMeasurementsResponseModelPostList responseEl = new SensorsMeasurementsResponseModelPostList(el.getTypeId(), el.getTypeName(), el.getTypeUnits(), el.getTypeFormula());
            responseList.add(responseEl);
        }

        SensorsResponseModelGetTypes response = new SensorsResponseModelGetTypes(responseList);
        return sensorsPresenter.prepareSuccessGetTypeView(response);
    }

    private SensorsResponseModelPost makeSensorsResponsePost(SensorsDSResponsePost dsResponse) {
       List<SensorsMeasurementsResponseModelPostList> sensorsMeasurements = new ArrayList<>();
       for (SensorsMeasurementsEntity sM : dsResponse.getSensorsMeasurements()){
           SensorsMeasurementsResponseModelPostList list = new SensorsMeasurementsResponseModelPostList(sM.getSensorsMeasurementsKey().getTypeId(), sM.getMeasurementsTypes().getTypeName(), sM.getMeasurementsTypes().getTypeUnits(), sM.getTypeFormula());
           sensorsMeasurements.add(list);
       }

        return new SensorsResponseModelPost(dsResponse.getSensor().getSensorId(), dsResponse.getSensor().getSensorName(), sensorsMeasurements);
    }
    
    private SensorsResponseModelGetAll makeSensorsResponseGetAll(List<SensorsEntity> dsResponsePostList){
        List<SensorsResponseModelPost> answer = new ArrayList<>();
        
        for (SensorsEntity sensor : dsResponsePostList){
            List<SensorsMeasurementsResponseModelPostList> measurementsList = new ArrayList<>();
            for (SensorsMeasurementsEntity sensorsMeasurements : sensor.getSensorsMeasurements()) {
                SensorsMeasurementsResponseModelPostList measurements = new SensorsMeasurementsResponseModelPostList(sensorsMeasurements.getSensorsMeasurementsKey().getTypeId(), sensorsMeasurements.getMeasurementsTypes().getTypeName(), sensorsMeasurements.getMeasurementsTypes().getTypeUnits(), sensorsMeasurements.getTypeFormula());
                measurementsList.add(measurements);
            }
            SensorsResponseModelPost model = new SensorsResponseModelPost(sensor.getSensorId(), sensor.getSensorName(), measurementsList);
            answer.add(model);
        }
        return new SensorsResponseModelGetAll(answer);
    }

}
