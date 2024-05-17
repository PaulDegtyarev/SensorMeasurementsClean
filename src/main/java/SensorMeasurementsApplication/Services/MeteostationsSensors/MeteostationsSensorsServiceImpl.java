package SensorMeasurementsApplication.Services.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.Delete.MeteostationsSensorsDelete;
import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.DataStores.Meteostations.MeteostationsDS;
import SensorMeasurementsApplication.DataStores.MeteostationsSensors.MeteostationsSensorsDS;
import SensorMeasurementsApplication.DataStores.Sensors.SensorsDS;
import SensorMeasurementsApplication.Factories.MeteostationsSensors.MeteostationsSensorsFactory;
import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.JPAEntities.SensorsEntity;
import SensorMeasurementsApplication.Presenters.Meteostations.MeteostationsPresenter;
import SensorMeasurementsApplication.Presenters.MeteostationsSensors.MeteostationsSensorsPresenter;
import SensorMeasurementsApplication.Presenters.Sensors.SensorsPresenter;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Delete.MeteostationsSensorsDeleteRequestBody;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Post.MSRequestBodyList;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Post.MeteostationsSensorsRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModel;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModelForDelete;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Get.MeteostationsSensorsGetResponseModel;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Get.MeteostationsSensorsMeteostationInfo;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Get.MeteostationsSensorsMeteostationsList;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Get.MeteostationsSensorsSensorsList;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MSPostList;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MeteostationsSensorsPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeteostationsSensorsServiceImpl implements MeteostationsSensorsService{
    @Autowired
    private MeteostationsSensorsDS meteostationsSensorsDS;
    private MeteostationsDS meteostationsDS;
    private SensorsDS sensorsDS;

    private MeteostationsSensorsPresenter meteostationsSensorsPresenter;
    private MeteostationsPresenter meteostationsPresenter;
    private SensorsPresenter sensorsPresenter;

    private MeteostationsSensorsFactory meteostationsSensorsFactory;

    public MeteostationsSensorsServiceImpl(MeteostationsSensorsDS meteostationsSensorsDS, MeteostationsDS meteostationsDS, SensorsDS sensorsDS, MeteostationsSensorsPresenter meteostationsSensorsPresenter, MeteostationsPresenter meteostationsPresenter, SensorsPresenter sensorsPresenter, MeteostationsSensorsFactory meteostationsSensorsFactory) {
        this.meteostationsSensorsDS = meteostationsSensorsDS;
        this.meteostationsDS = meteostationsDS;
        this.sensorsDS = sensorsDS;
        this.meteostationsSensorsPresenter = meteostationsSensorsPresenter;
        this.meteostationsPresenter = meteostationsPresenter;
        this.sensorsPresenter = sensorsPresenter;
        this.meteostationsSensorsFactory = meteostationsSensorsFactory;
    }

    @Override
    public MeteostationsSensorsPostResponse create(MeteostationsSensorsRequestBody data){
        for (MSRequestBodyList el : data.getMeteostations_sensors()) {
            if (!meteostationsDS.existsByStationId(el.getStation_id())) throw meteostationsPresenter.prepareNotFoundView();
            if (sensorsDS.existsBySensorId(el.getSensor_id())) throw sensorsPresenter.prepareSensorsNotFoundView();
            if (meteostationsSensorsDS.existsByStationIdAndSensorId(el.getStation_id(), el.getSensor_id())) throw meteostationsSensorsPresenter.prepareConflictView();
        }

        List<MeteostationsSensors> models = meteostationsSensorsFactory.create(data);

        MeteostationsSensorsDSRequestModel dsRequest = new MeteostationsSensorsDSRequestModel(models);

        List<MeteostationsSensorsEntity> dsResponse = meteostationsSensorsDS.create(dsRequest);

        return meteostationsSensorsPresenter.prepareSuccessPostView(makePostResponse(dsResponse));
    }

    @Override
    public void delete(Integer sensorInventoryNumber, MeteostationsSensorsDeleteRequestBody data){
        if (!meteostationsSensorsDS.existsBySensorInventoryNumber(sensorInventoryNumber)) throw meteostationsSensorsPresenter.prepareNotFoundView();

        MeteostationsSensorsDelete model = meteostationsSensorsFactory.createForDelete(sensorInventoryNumber, data);

        MeteostationsSensorsDSRequestModelForDelete dsRequest = new MeteostationsSensorsDSRequestModelForDelete(model.getSensorInventoryNumber(), model.getRemovedTS());

        meteostationsSensorsDS.delete(dsRequest);
    }

    @Override
    public MeteostationsSensorsGetResponseModel get(){
        List<MeteostationsSensorsEntity> dsResponse = meteostationsSensorsDS.get();

        return meteostationsSensorsPresenter.prepareSuccsessGetView(makeGetResponse(dsResponse));
    }

    private MeteostationsSensorsPostResponse makePostResponse(List<MeteostationsSensorsEntity> dsResponse){
        List<MSPostList> response = new ArrayList<>();

        for (MeteostationsSensorsEntity el : dsResponse){
            MSPostList responseEl = new MSPostList(el.getSensorInventoryNumber(), el.getStationId(),el.getSensorId(), el.getAddedTS());
            response.add(responseEl);
        }

        return new MeteostationsSensorsPostResponse(response);
    }

    private Map<Integer, List<MeteostationsSensorsSensorsList>> prepareMapForGetResponse(List<MeteostationsSensorsEntity> dsResponse){
        Map<Integer, List<MeteostationsSensorsSensorsList>> meteostationSensorsMap = new HashMap<>();

        for (MeteostationsSensorsEntity el : dsResponse){
            MeteostationsEntity meteostation = el.getMeteostation();
            SensorsEntity sensors = el.getSensor();

            MeteostationsSensorsSensorsList sensorsEl = new MeteostationsSensorsSensorsList(el.getSensorInventoryNumber(), sensors.getSensorId(), sensors.getSensorName(), el.getAddedTS(), el.getRemovedTS());

            List<MeteostationsSensorsSensorsList> sensorsList = meteostationSensorsMap.getOrDefault(meteostation.getStationId(), new ArrayList<>());

            sensorsList.add(sensorsEl);

            meteostationSensorsMap.put(meteostation.getStationId(), sensorsList);
        }

        return meteostationSensorsMap;
    }


    private MeteostationsSensorsGetResponseModel makeGetResponse(List<MeteostationsSensorsEntity> dsResponse) {
        Map<Integer, List<MeteostationsSensorsSensorsList>> meteostationSensorsMap = prepareMapForGetResponse(dsResponse);

        List<MeteostationsSensorsMeteostationsList> meteostationsSensors = new ArrayList<>();
        for (Map.Entry<Integer, List<MeteostationsSensorsSensorsList>> entry : meteostationSensorsMap.entrySet()){
            Integer stationId = entry.getKey();
            List<MeteostationsSensorsSensorsList> sensors = entry.getValue();

            MeteostationsEntity meteostationsEntity = meteostationsDS.one(stationId);

            MeteostationsSensorsMeteostationInfo meteostation = new MeteostationsSensorsMeteostationInfo(meteostationsEntity.getStationId(), meteostationsEntity.getStationName(), meteostationsEntity.getStationLongitude(), meteostationsEntity.getStationLatitude(), sensors);

            MeteostationsSensorsMeteostationsList meteostationModel = new MeteostationsSensorsMeteostationsList(meteostation);

            meteostationsSensors.add(meteostationModel);
        }

        return new MeteostationsSensorsGetResponseModel(meteostationsSensors);
    }
}
