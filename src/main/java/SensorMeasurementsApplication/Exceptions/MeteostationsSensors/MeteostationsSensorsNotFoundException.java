package SensorMeasurementsApplication.Exceptions.MeteostationsSensors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeteostationsSensorsNotFoundException extends ResponseStatusException {
    public MeteostationsSensorsNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
