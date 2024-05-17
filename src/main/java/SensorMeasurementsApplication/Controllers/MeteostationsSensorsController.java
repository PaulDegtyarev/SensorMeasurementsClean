package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Delete.MeteostationsSensorsDeleteRequestBody;
import SensorMeasurementsApplication.RequestBodies.MeteostationsSensors.Post.MeteostationsSensorsRequestBody;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Get.MeteostationsSensorsGetResponseModel;
import SensorMeasurementsApplication.Responses.MeteostationsSensors.Post.MeteostationsSensorsPostResponse;
import SensorMeasurementsApplication.Services.MeteostationsSensors.MeteostationsSensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/meteostations_sensors/{sensor_inventory_number}/removed_ts")
    void delete(@PathVariable("sensor_inventory_number") Integer sensorInventoryNumber,
                @RequestBody MeteostationsSensorsDeleteRequestBody data){meteostationsSensorsService.delete(sensorInventoryNumber, data);}

    @GetMapping("/meteostations_sensors")
    MeteostationsSensorsGetResponseModel get(){
        return meteostationsSensorsService.get();
    }

}
