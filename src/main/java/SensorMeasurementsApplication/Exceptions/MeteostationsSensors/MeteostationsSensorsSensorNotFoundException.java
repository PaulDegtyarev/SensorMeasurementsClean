package SensorMeasurementsApplication.Exceptions.MeteostationsSensors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class MeteostationsSensorsSensorNotFoundException extends ResponseStatusException {
    public MeteostationsSensorsSensorNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
