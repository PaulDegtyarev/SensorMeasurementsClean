package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;
import SensorMeasurementsApplication.Services.Measurements.MeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementsController {
    @Autowired
    private MeasurementsService measurementsService;

    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @PostMapping("/measurements")
    ResponseEntity<MeasurementsPostResponseModel> create(@RequestBody MeasurementsRequestBody data){
        return new ResponseEntity<>(measurementsService.create(data), HttpStatus.CREATED);
    }
}
