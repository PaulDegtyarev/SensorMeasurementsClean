package SensorMeasurementsApplication.Services.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.DataStores.Measurements.MeasurementsDS;
import SensorMeasurementsApplication.Factories.Measurements.MeasurementsFactory;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.Presenters.Measurements.MeasurementsPresenter;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBodyList;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseList;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

@Service
public class MeasurementsServiceImpl implements MeasurementsService {
    @Autowired
    private MeasurementsDS measurementsDS;
    private MeasurementsPresenter measurementsPresenter;

    private MeasurementsFactory measurementsFactory;

    public MeasurementsServiceImpl(MeasurementsDS measurementsDS, MeasurementsPresenter measurementsPresenter, MeasurementsFactory measurementsFactory) {
        this.measurementsDS = measurementsDS;
        this.measurementsPresenter = measurementsPresenter;
        this.measurementsFactory = measurementsFactory;
    }

    @Override
    public MeasurementsPostResponseModel create(MeasurementsRequestBodyList data){
        for (MeasurementsRequestBody el : data.getMeasurements()) {
            if (!measurementsDS.existsByTypeId(el.getMeasurement_type())) throw measurementsPresenter.prepareNotFoundView();
            if (!measurementsDS.existsBySensorInventoryNumber(el.getSensor_inventory_number())) throw measurementsPresenter.prepareNotFoundView();
        }

        List<Measurements> measurements = measurementsFactory.create(data);

        MeasurementsDSRequesModel dsRequest = new MeasurementsDSRequesModel(measurements);

        List<MeasurementsEntity> dsResponse = measurementsDS.create(dsRequest);

        return measurementsPresenter.prepareSuccessPostView(makePostResponse(dsResponse));
    }

    @Override
    public MeasurementsPostResponseModel byParam(Integer sensorInventoryNumber){
        if (!measurementsDS.existsByMeasurementsKey_SensorInventoryNumber(sensorInventoryNumber)) throw measurementsPresenter.prepareNotFoundView();

        List<MeasurementsEntity> dsResponse = measurementsDS.getByParam(sensorInventoryNumber);

        return measurementsPresenter.prepareSuccessPostView(makePostResponse(dsResponse));

    }

    @Override
    public MeasurementsPostResponseModel all(){
        List<MeasurementsEntity> dsResponse = measurementsDS.all();

        return measurementsPresenter.prepareSuccessPostView(makePostResponse(dsResponse));
    }

    private MeasurementsPostResponseModel makePostResponse(List<MeasurementsEntity> dsResponse){
        List<MeasurementsPostResponseList> measurements = new ArrayList<>();

        for (MeasurementsEntity el : dsResponse){
            MeasurementsPostResponseList model = new MeasurementsPostResponseList(el.getMeasurementsKey().getMeasurementValue(), el.getMeasurementsKey().getMeasurementTS(), el.getMeasurementsKey().getSensorInventoryNumber(), el.getMeasurementsKey().getMeasurementType());
            measurements.add(model);
        }

        return new MeasurementsPostResponseModel(measurements);
    }

}
