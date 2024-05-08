package SensorMeasurementsApplication.Exceptions.Sensors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SensorsNotFoundException extends ResponseStatusException {
    public SensorsNotFoundException(){super(HttpStatus.NOT_FOUND);}
}
