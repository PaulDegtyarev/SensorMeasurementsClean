package SensorMeasurementsApplication.Factories.Meteostations;

import SensorMeasurementsApplication.CustomModels.Meteostations.Meteostation;
import SensorMeasurementsApplication.CustomModels.Meteostations.MeteostationImpl;
import SensorMeasurementsApplication.RequestBodies.Meteostations.MeteostationRequestBody;
import org.springframework.stereotype.Component;

@Component
public class MeteostationFactoryImpl implements MeteostationFactory {
    @Override
    public Meteostation create(MeteostationRequestBody data){
        return new MeteostationImpl(data.getStation_name(), data.getStation_longitude(), data.getStation_latitude(), data.getStation_country());
    }

    @Override
    public Meteostation createByParam(String stationName, Double stationLongitude, Double stationLatitude, String stationCountry){
        return new MeteostationImpl(stationName, stationLongitude, stationLatitude, stationCountry);
    }

    @Override
    public String checkStringNotNull(String str){
        if (str.isEmpty()) return null;
        return str;
    }
}
