package SensorMeasurementsApplication.Exceptions.MeasurementsTypes;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeasurementsTypeNotFoundException extends ResponseStatusException {
    public MeasurementsTypeNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
