package SensorMeasurementsApplication.Exceptions.Measurements;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeasurementsBadRequestException extends ResponseStatusException {
    public MeasurementsBadRequestException(){super(HttpStatus.BAD_REQUEST);}
}
