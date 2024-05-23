package SensorMeasurementsApplication.Exceptions.SensorsMeasurements;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SensorsMeasurementsTypeNotFoundException extends ResponseStatusException {
    public SensorsMeasurementsTypeNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
