package SensorMeasurementsApplication.Exceptions.MeasurementsTypes;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeasurementsTypeConflictException extends ResponseStatusException {
    public MeasurementsTypeConflictException(){super(HttpStatus.CONFLICT);}
}
