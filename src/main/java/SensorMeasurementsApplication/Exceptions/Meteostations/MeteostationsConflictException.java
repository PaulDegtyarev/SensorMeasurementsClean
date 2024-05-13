package SensorMeasurementsApplication.Exceptions.Meteostations;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeteostationsConflictException extends ResponseStatusException {
    public MeteostationsConflictException(){super(HttpStatus.CONFLICT);}
}
