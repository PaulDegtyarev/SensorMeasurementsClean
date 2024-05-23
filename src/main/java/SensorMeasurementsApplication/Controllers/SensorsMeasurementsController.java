package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Delete.SensorsMeasurementsRequestBodyDelete;
import SensorMeasurementsApplication.RequestBodies.SensorsMeasurements.Post.SensorsMeasurementsRequesBody;
import SensorMeasurementsApplication.Responses.SensorsMeasurements.SensorsMeasurementsResponseModel;
import SensorMeasurementsApplication.Services.SensorsMeasurements.SensorsMeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorsMeasurementsController {
    private SensorsMeasurementsService sensorsMeasurementsService;

    @Autowired
    public SensorsMeasurementsController(SensorsMeasurementsService sensorsMeasurementsService) {
        this.sensorsMeasurementsService = sensorsMeasurementsService;
    }

    @PostMapping("/sensors_measurements/{sensor_id}")
    @Transactional
    ResponseEntity<SensorsMeasurementsResponseModel> create(@PathVariable("sensor_id") Integer sensorId,
                                                            @RequestBody SensorsMeasurementsRequesBody data){return new ResponseEntity<>(sensorsMeasurementsService.create(sensorId, data), HttpStatus.CREATED);}

    @DeleteMapping("/sensors_measurements/{sensor_id}")
    void delete(@PathVariable("sensor_id") Integer sensorId,
                @RequestBody SensorsMeasurementsRequestBodyDelete measurementsType){sensorsMeasurementsService.delete(sensorId, measurementsType);}
}
