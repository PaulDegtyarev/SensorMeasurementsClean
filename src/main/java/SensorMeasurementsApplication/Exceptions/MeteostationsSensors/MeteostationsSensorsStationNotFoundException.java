package SensorMeasurementsApplication.Exceptions.MeteostationsSensors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeteostationsSensorsStationNotFoundException extends ResponseStatusException {
    public MeteostationsSensorsStationNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
