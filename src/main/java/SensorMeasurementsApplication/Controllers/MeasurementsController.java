package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBody;
import SensorMeasurementsApplication.RequestBodies.Measurements.MeasurementsRequestBodyList;
import SensorMeasurementsApplication.Responses.Measurements.Post.MeasurementsPostResponseModel;
import SensorMeasurementsApplication.Services.Measurements.MeasurementsService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.lang.System.out;

@RestController
public class MeasurementsController {
    private MeasurementsService measurementsService;

    @Autowired
    public MeasurementsController(MeasurementsService measurementsService) {
        this.measurementsService = measurementsService;
    }

    @PostMapping("/measurements")
    @Transactional
    ResponseEntity<MeasurementsPostResponseModel> create(@RequestBody MeasurementsRequestBodyList data){
        return new ResponseEntity<>(measurementsService.create(data), HttpStatus.CREATED);
    }

    @GetMapping("/measurement")
    MeasurementsPostResponseModel byParam(@RequestParam("sensor_inventory_number") Integer sensorInventoryNumber){
        return measurementsService.byParam(sensorInventoryNumber);
    }

    @GetMapping("/measurements")
    MeasurementsPostResponseModel all(){return measurementsService.all();}

    @DeleteMapping("/measurements/{station_id}/meteostation")
    void deleteByStationId(@PathVariable("station_id") Integer stationId){measurementsService.deleteByStationId(stationId);}

    @DeleteMapping("/measurements/{sensor_id}/sensor")
    void deleteBySensorId(@PathVariable("sensor_id") Integer sensorId){measurementsService.deleteBySensorId(sensorId);}

    @DeleteMapping("/measurements")
    void deleteByTime(
            @PathParam("from") String from,
            @PathParam("to") String to){measurementsService.deleteByTime(from, to);}


}
