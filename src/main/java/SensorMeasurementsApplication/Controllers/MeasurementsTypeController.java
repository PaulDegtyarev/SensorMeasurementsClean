package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.MeasurementsTypes.MeasurementsTypesRequestBody;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelGetAll;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelPost;
import SensorMeasurementsApplication.Services.MeasurementsTypes.MeasurementsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class MeasurementsTypeController {
    @Autowired
    private MeasurementsTypeService measurementsTypeService;

    public MeasurementsTypeController(MeasurementsTypeService measurementsTypeService) {
        this.measurementsTypeService = measurementsTypeService;
    }

    @PostMapping("/types")
    @Transactional
    ResponseEntity<MeasurementsTypeResponseModelPost> create(@RequestBody MeasurementsTypesRequestBody data){return new ResponseEntity<>(measurementsTypeService.create(data), HttpStatus.CREATED);}

    @DeleteMapping("/types/{type_id}")
    void delete(@PathVariable("type_id") Integer typeId){
        measurementsTypeService.delete(typeId);
    }

    @PutMapping("/types/{type_id}")
    void update(@PathVariable("type_id") Integer typeId,
                @RequestBody MeasurementsTypesRequestBody data){measurementsTypeService.update(typeId, data);}

    @GetMapping("/types")
    MeasurementsTypeResponseModelGetAll getAll(){return measurementsTypeService.getAll();}
}
