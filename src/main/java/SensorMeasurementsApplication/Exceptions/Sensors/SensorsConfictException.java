package SensorMeasurementsApplication.Exceptions.Sensors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SensorsConfictException extends ResponseStatusException {
    public SensorsConfictException(){super(HttpStatus.CONFLICT);}
}
