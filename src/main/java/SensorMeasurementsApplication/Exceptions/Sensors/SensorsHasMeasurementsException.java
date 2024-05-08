package SensorMeasurementsApplication.Exceptions.Sensors;


import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;


@ResponseStatus(reason = "Sensor has measurements")
public class SensorsHasMeasurementsException extends ResponseStatusException {
    public SensorsHasMeasurementsException(String message){super(HttpStatus.OK, message);}
}
