package SensorMeasurementsApplication.Factories.Meteostations;

import SensorMeasurementsApplication.CustomModels.Meteostations.Meteostation;
import SensorMeasurementsApplication.RequestBodies.Meteostations.MeteostationRequestBody;

import java.util.Optional;

public interface MeteostationFactory {
    Meteostation create(MeteostationRequestBody data);

    Meteostation createByParam(String stationName, Double stationLongitude, Double stationLatitude, String stationCountry);

    String checkStringNotNull(String str);
}
