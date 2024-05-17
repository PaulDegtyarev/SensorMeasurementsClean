package SensorMeasurementsApplication.Services.Measurements;

import SensorMeasurementsApplication.CustomModels.Measurements.Measurements;
import SensorMeasurementsApplication.DataStores.Measurements.MeasurementsDS;
import SensorMeasurementsApplication.DataStores.MeasurementsTypes.MeasurementsTypeDS;
import SensorMeasurementsApplication.DataStores.MeteostationsSensors.MeteostationsSensorsDS;
import SensorMeasurementsApplication.Factories.Measurements.MeasurementsFactory;
import SensorMeasurementsApplication.JPAEntities.Measurements.MeasurementsEntity;
import SensorMeasurementsApplication.Presenters.Measurements.MeasurementsPresenter;
import SensorMeasurementsApplication.Presenters.MeasurementsTypes.MeasurementsTypePresenter;
import SensorMeasurementsApplication.Presenters.MeteostationsSensors.MeteostationsSensorsPresenter;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.RequestDataStoreModels.Measurements.MeasurementsDSRequesModel;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementsServiceImpl implements MeasurementsService {
    @Autowired
    private MeasurementsDS measurementsDS;
    private MeasurementsTypeDS measurementsTypeDS;
    private MeteostationsSensorsDS meteostationsSensorsDS;

    private MeasurementsPresenter measurementsPresenter;
    private MeasurementsTypePresenter measurementsTypePresenter;
    private MeteostationsSensorsPresenter meteostationsSensorsPresenter;

    private MeasurementsFactory measurementsFactory;

    public MeasurementsServiceImpl(MeasurementsDS measurementsDS, MeasurementsTypeDS measurementsTypeDS, MeteostationsSensorsDS meteostationsSensorsDS, MeasurementsPresenter measurementsPresenter, MeasurementsTypePresenter measurementsTypePresenter, MeteostationsSensorsPresenter meteostationsSensorsPresenter, MeasurementsFactory measurementsFactory) {
        this.measurementsDS = measurementsDS;
        this.measurementsTypeDS = measurementsTypeDS;
        this.meteostationsSensorsDS = meteostationsSensorsDS;
        this.measurementsPresenter = measurementsPresenter;
        this.measurementsTypePresenter = measurementsTypePresenter;
        this.meteostationsSensorsPresenter = meteostationsSensorsPresenter;
        this.measurementsFactory = measurementsFactory;
    }

    @Override
    public MeasurementsPostResponseModel create(MeasurementsRequestBody data){
        if (!measurementsTypeDS.existsByTypeId(data.getMeasurement_type())) throw measurementsTypePresenter.prepareMeasurementsTypeNotFoundView();
        if (!meteostationsSensorsDS.existsBySensorInventoryNumber(data.getSensor_inventory_number())) throw meteostationsSensorsPresenter.prepareNotFoundView();

        Measurements measurement = measurementsFactory.create(data);

        MeasurementsDSRequesModel dsRequest = new MeasurementsDSRequesModel(measurement.getMeasurementsValue(), measurement.getMeasurementTS(), measurement.getSensorInventoryNumber(), measurement.getMeasurementType());

        MeasurementsEntity dsResponse = measurementsDS.create(dsRequest);

        MeasurementsPostResponseModel response = new MeasurementsPostResponseModel(dsResponse.getMeasurementsKey().getMeasurementValue(), dsResponse.getMeasurementsKey().getMeasurementTS(), dsResponse.getMeasurementsKey().getSensorInventoryNumber(), dsResponse.getMeasurementsKey().getMeasurementType());

        return measurementsPresenter.prepareSuccessPostView(response);
    }
}
