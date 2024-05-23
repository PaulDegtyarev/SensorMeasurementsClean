package SensorMeasurementsApplication.Services.Meteostations;

import SensorMeasurementsApplication.CustomModels.Meteostations.Meteostation;
import SensorMeasurementsApplication.DataStores.Meteostations.MeteostationsDS;
import SensorMeasurementsApplication.Factories.Meteostations.MeteostationFactory;
import SensorMeasurementsApplication.JPAEntities.MeteostationsEntity;
import SensorMeasurementsApplication.JPAEntities.MeteostationsSensorsEntity;
import SensorMeasurementsApplication.Presenters.Meteostations.MeteostationsPresenter;
import SensorMeasurementsApplication.RequestBodies.Meteostations.MeteostationRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.Meteostations.MeteostationsDSRequestModel;
import SensorMeasurementsApplication.Responses.Meteostations.MeteostationResponseModel;
import SensorMeasurementsApplication.Responses.Meteostations.WithSensors.MeteostationsWithSensorsReponseModel;
import SensorMeasurementsApplication.Responses.Meteostations.WithSensors.SensorsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeteostationsServiceImpl implements MeteostationsService {
    private MeteostationsDS meteostationsDS;
    private MeteostationFactory meteostationFactory;
    private MeteostationsPresenter meteostationsPresenter;

    @Autowired
    public MeteostationsServiceImpl(MeteostationsDS meteostationsDS, MeteostationFactory meteostationFactory, MeteostationsPresenter meteostationsPresenter) {
        this.meteostationsDS = meteostationsDS;
        this.meteostationFactory = meteostationFactory;
        this.meteostationsPresenter = meteostationsPresenter;
    }

    @Override
    public MeteostationResponseModel create(MeteostationRequestBody data){
        if (meteostationsDS.existsByStationNameOrStationLongitudeAndStationLatitude(data.getStation_name(), data.getStation_longitude(), data.getStation_latitude())) throw meteostationsPresenter.prepareConflictView();

        Meteostation meteostation = meteostationFactory.create(data);

        MeteostationsDSRequestModel dsRequest = new MeteostationsDSRequestModel(meteostation.getStationName(), meteostation.getStationLongitude(), meteostation.getStationLatitude(), meteostation.getStationCountry());

        MeteostationsEntity dsResponse = meteostationsDS.create(dsRequest);

        MeteostationResponseModel response = new MeteostationResponseModel(dsResponse.getStationId(), dsRequest.getStationName(), dsRequest.getStationLongitude(), dsRequest.getStationLatitude(), dsRequest.getStationCountry());

        return meteostationsPresenter.prepareSuccessPostView(response);
    }

    @Override
    public void delete(Integer stationId){
        if (!meteostationsDS.existsByStationId(stationId)) throw meteostationsPresenter.prepareNotFoundView();
        if (meteostationsDS.hasMeasurements(stationId)) throw meteostationsPresenter.prepareConflictView();
        meteostationsDS.delete(stationId);
    }

    @Override
    public void update(Integer stationId, MeteostationRequestBody data){
        if (!meteostationsDS.existsByStationId(stationId)) throw meteostationsPresenter.prepareNotFoundView();
        if (meteostationsDS.existsByStationNameOrStationLongitudeAndStationLatitude(data.getStation_name(), data.getStation_longitude(), data.getStation_latitude())) throw meteostationsPresenter.prepareConflictView();
        meteostationsDS.update(stationId, data);
    }

    @Override
    public List<MeteostationResponseModel> all(){
        List<MeteostationsEntity> dsReponse = meteostationsDS.all();

        return meteostationsPresenter.prepareSuccessGetAllView(makeAllResponse(dsReponse));
    }

    @Override
    public MeteostationResponseModel one(Integer stationId){
        if (!meteostationsDS.existsByStationId(stationId)) throw meteostationsPresenter.prepareNotFoundView();

        MeteostationsEntity dsReponse = meteostationsDS.one(stationId);

        MeteostationResponseModel response = new MeteostationResponseModel(dsReponse.getStationId(), dsReponse.getStationName(), dsReponse.getStationLongitude(), dsReponse.getStationLatitude(), dsReponse.getStationCountry());
        return meteostationsPresenter.prepareSuccessPostView(response);
    }

    @Override
    public List<MeteostationResponseModel> byParam(String stationName, Double stationLongitude, Double stationLatitude, String stationCountry){
        String checkedStationName = meteostationFactory.checkStringNotNull(stationName);
        String  checkedStationCountry = meteostationFactory.checkStringNotNull(stationCountry);
        Meteostation meteostation = meteostationFactory.createByParam(checkedStationName, stationLongitude, stationLatitude, checkedStationCountry);

        MeteostationsDSRequestModel dsRequest = new MeteostationsDSRequestModel(meteostation.getStationName(), meteostation.getStationLongitude(), meteostation.getStationLatitude(), meteostation.getStationCountry());
        List<MeteostationsEntity> dsReponse = meteostationsDS.byParam(dsRequest);

        return meteostationsPresenter.prepareSuccessGetAllView(makeAllResponse(dsReponse));
    }

    @Override
    public MeteostationsWithSensorsReponseModel withSensors(Integer stationId){
        if (!meteostationsDS.existsByStationId(stationId)) throw meteostationsPresenter.prepareNotFoundView();

        MeteostationsEntity dsResponse = meteostationsDS.withSensors(stationId);

        return meteostationsPresenter.prepareSuccessWithSensorsView(makeWithSensorsResponse(dsResponse));
    }

    private List<MeteostationResponseModel> makeAllResponse(List<MeteostationsEntity> dsReponse){
        List<MeteostationResponseModel> responseList = new ArrayList<>();
        for (MeteostationsEntity el : dsReponse){
            MeteostationResponseModel response = new MeteostationResponseModel(el.getStationId(), el.getStationName(), el.getStationLongitude(), el.getStationLatitude(), el.getStationCountry());
            responseList.add(response);
        }

        return responseList;
    }

    private MeteostationsWithSensorsReponseModel makeWithSensorsResponse(MeteostationsEntity dsResponse){
        MeteostationResponseModel meteostation = new MeteostationResponseModel(dsResponse.getStationId(), dsResponse.getStationName(), dsResponse.getStationLongitude(), dsResponse.getStationLatitude(), dsResponse.getStationCountry());
        List<SensorsList> sensorsList = new ArrayList<>();

        for (MeteostationsSensorsEntity el : dsResponse.getMeteostationsSensors()){
            SensorsList listEl = new SensorsList(el.getSensor().getSensorId(), el.getSensor().getSensorName());
            sensorsList.add(listEl);
        }

        return new MeteostationsWithSensorsReponseModel(meteostation, sensorsList);
    }
}
