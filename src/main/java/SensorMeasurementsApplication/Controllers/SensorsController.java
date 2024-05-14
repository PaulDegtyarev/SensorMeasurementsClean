package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.CustomModels.Sensors.Sensor;
import SensorMeasurementsApplication.DataStores.Sensors.SensorsDS;
import SensorMeasurementsApplication.RequestBodies.Sensors.Post.SensorsPostRequestBody;
import SensorMeasurementsApplication.RequestBodies.Sensors.Put.SensorsRequestModelPut;
import SensorMeasurementsApplication.Responses.Sensors.GetAll.SensorsResponseModelGetAll;
import SensorMeasurementsApplication.Responses.Sensors.GetTypes.SensorsResponseModelGetTypes;
import SensorMeasurementsApplication.Responses.Sensors.Post.SensorsResponseModelPost;
import SensorMeasurementsApplication.Services.Sensors.SensorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SensorsController {
    @Autowired
    private SensorsService sensorsService;

    public SensorsController(SensorsService sensorsService) {
        this.sensorsService = sensorsService;
    }

    @PostMapping("/sensor")
    @Transactional
    SensorsResponseModelPost create(@RequestBody SensorsPostRequestBody data){
        return sensorsService.create(data);
    }

    @DeleteMapping("/sensor/{sensor_id}")
    void delete(@PathVariable("sensor_id") Integer sensorId){
        sensorsService.delete(sensorId);
    }

    @PutMapping("/sensor/{sensor_id}")
    void update(@PathVariable("sensor_id") Integer sensorId,
                       @RequestBody SensorsRequestModelPut data){
        sensorsService.update(sensorId, data.getSensor_name());
    }

    @GetMapping("/sensor")
    SensorsResponseModelGetAll all(){
        return sensorsService.all();
    }

    @GetMapping("/sensor/{sensor_id}")
    SensorsResponseModelPost one(@PathVariable("sensor_id") Integer sensorId){
        return sensorsService.one(sensorId);
    }

    @GetMapping("/sensor/{sensor_id}/type")
    SensorsResponseModelGetTypes byType(@PathVariable("sensor_id") Integer sensorId){
        return sensorsService.byType(sensorId);
    }
}
