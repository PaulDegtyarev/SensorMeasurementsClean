package SensorMeasurementsApplication.Services.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.DataStores.Meteostations.MeteostationsDS;
import SensorMeasurementsApplication.DataStores.MeteostationsSensors.MeteostationsSensorsDS;
import SensorMeasurementsApplication.DataStores.Sensors.SensorsDS;
import SensorMeasurementsApplication.Factories.MeteostationsSensors.MeteostationsSensorsFactory;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.Presenters.Meteostations.MeteostationsPresenter;
import SensorMeasurementsApplication.Presenters.MeteostationsSensors.MeteostationsSensorsPresenter;
import SensorMeasurementsApplication.Presenters.Sensors.SensorsPresenter;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.MSRequestBodyList;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.MeteostationsSensorsRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.MeteostationsSensors.MeteostationsSensorsDSRequestModel;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MSPostList;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MeteostationsSensorsPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    private MeteostationsSensorsPostResponse makePostResponse(List<MeteostationsSensorsEntity> dsResponse){
        List<MSPostList> response = new ArrayList<>();

        for (MeteostationsSensorsEntity el : dsResponse){
            MSPostList responseEl = new MSPostList(el.getSensorInventoryNumber(), el.getStationId(),el.getSensorId(), el.getAddedTS());
            response.add(responseEl);
        }

        return new MeteostationsSensorsPostResponse(response);
    }
}
