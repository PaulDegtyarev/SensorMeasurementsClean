package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.RequestBodies.MeasurementsTypesRequestBody.MeasurementsTypesRequestBody;
import SensorMeasurementsApplication.Responses.MeasurementsTypes.MeasurementsTypeResponseModelPost;
import SensorMeasurementsApplication.Services.MeasurementsTypes.MeasurementsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementsTypeController {
    @Autowired
    private final MeasurementsTypeService measurementsTypeService;

    public MeasurementsTypeController(MeasurementsTypeService measurementsTypeService) {
        this.measurementsTypeService = measurementsTypeService;
    }

    @PostMapping("/types")
    @Transactional
    MeasurementsTypeResponseModelPost create(@RequestBody MeasurementsTypesRequestBody data){
        return measurementsTypeService.create(data);
    }
}
