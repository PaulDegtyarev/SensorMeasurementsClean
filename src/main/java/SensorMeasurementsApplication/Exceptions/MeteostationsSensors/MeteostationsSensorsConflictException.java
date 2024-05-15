package SensorMeasurementsApplication.Exceptions.MeteostationsSensors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeteostationsSensorsConflictException extends ResponseStatusException {
    public MeteostationsSensorsConflictException(){super(HttpStatus.CONFLICT);}
}
