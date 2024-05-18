package SensorMeasurementsApplication.Exceptions.MeasurementsTypes;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MeasurementsTypeBadRequestException extends ResponseStatusException {
    public MeasurementsTypeBadRequestException(){super(HttpStatus.BAD_REQUEST);}
}
