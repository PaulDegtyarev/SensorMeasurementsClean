package SensorMeasurementsApplication.Exceptions.Measurements;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeasurementsNotFoundException extends ResponseStatusException {
    public MeasurementsNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
