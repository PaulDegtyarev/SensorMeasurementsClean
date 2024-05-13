package SensorMeasurementsApplication.Exceptions.Meteostations;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeteostationsNotFoundException extends ResponseStatusException {
    public MeteostationsNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
