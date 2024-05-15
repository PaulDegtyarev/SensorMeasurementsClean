package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.MeteostationsSensorsRequestBody;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MeteostationsSensorsPostResponse;
import SensorMeasurementsApplication.Services.MeteostationsSensors.MeteostationsSensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeteostationsSensorsController {
    @Autowired
    private MeteostationsSensorsService meteostationsSensorsService;

    public MeteostationsSensorsController(MeteostationsSensorsService meteostationsSensorsService) {
        this.meteostationsSensorsService = meteostationsSensorsService;
    }

    @PostMapping("/meteostations_sensors")
    @Transactional
    ResponseEntity<MeteostationsSensorsPostResponse> create(@RequestBody MeteostationsSensorsRequestBody data){
        return new ResponseEntity<>(meteostationsSensorsService.create(data), HttpStatus.CREATED);
    }
}
