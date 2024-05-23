package SensorMeasurementsApplication.Exceptions.MeteostationsSensors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeteostationsSensorsInvNumbNotFoundException extends ResponseStatusException {
    public MeteostationsSensorsInvNumbNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
