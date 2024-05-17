package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBodyList;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;
import SensorMeasurementsApplication.Services.Measurements.MeasurementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeasurementsController {
    @Autowired
    private MeasurementsService measurementsService;

    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @PostMapping("/measurements")
    ResponseEntity<MeasurementsPostResponseModel> create(@RequestBody MeasurementsRequestBodyList data){
        return new ResponseEntity<>(measurementsService.create(data), HttpStatus.CREATED);
    }

    @GetMapping("/measurement")
    MeasurementsPostResponseModel byParam(@RequestParam("sensor_inventory_number") Integer sensorInventoryNumber){
        return measurementsService.byParam(sensorInventoryNumber);
    }

    @GetMapping("/measurements")
    MeasurementsPostResponseModel all(){return measurementsService.all();}
}
