package SensorMeasurementsApplication.Exceptions.SensorsMeasurements;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SensorsMeasurementsSensorNotFoundException extends ResponseStatusException {
    public SensorsMeasurementsSensorNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
