package SensorMeasurementsApplication.Factories.MeteostationsSensors;

import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensors;
import SensorMeasurementsApplication.CustomModels.MeteostationsSensors.MeteostationsSensorsImpl;

import java.sql.Timestamp;
import java.time.Instant;

public class MeteostationsSensorsFactoryImpl implements MeteostationsSensorsFactory {
    public MeteostationsSensors create(Integer sensorInventoryNumber,
                                       Integer stationId,
                                       Integer sensorId,
                                       Instant addedTS,
                                       Timestamp removedTS){
        return new MeteostationsSensorsImpl(sensorInventoryNumber, stationId, sensorId, addedTS, removedTS);
    }
}
