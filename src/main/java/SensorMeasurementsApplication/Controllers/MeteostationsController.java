package SensorMeasurementsApplication.Controllers;

import SensorMeasurementsApplication.Conventer.Conventer;
import SensorMeasurementsApplication.Conventer.StringNotNullConventer;
import SensorMeasurementsApplication.RequestBodies.Meteostations.MeteostationRequestBody;
import SensorMeasurementsApplication.Responses.Meteostations.MeteostationResponseModel;
import SensorMeasurementsApplication.Services.Meteostations.MeteostationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.System.out;

@RestController
public class MeteostationsController {
    @Autowired
    private final MeteostationsService meteostationsService;

    public MeteostationsController(MeteostationsService meteostationsService) {
        this.meteostationsService = meteostationsService;
    }

    @PostMapping("/meteostations")
    ResponseEntity<MeteostationResponseModel> create(@RequestBody MeteostationRequestBody data){
        return new ResponseEntity<>(meteostationsService.create(data), HttpStatus.CREATED);
    }

    @DeleteMapping("/meteostations/{station_id}")
    void delete(@PathVariable("station_id") Integer stationId){
        meteostationsService.delete(stationId);
    }

    @PutMapping("/meteostations/{station_id}")
    void update(@PathVariable("station_id") Integer stationId,
                @RequestBody MeteostationRequestBody data){meteostationsService.update(stationId, data);}

    @GetMapping("/meteostations")
    List<MeteostationResponseModel> all(){return meteostationsService.all();}

    @GetMapping("/meteostations/{station_id}")
    MeteostationResponseModel one(@PathVariable("station_id") Integer stationId){return meteostationsService.one(stationId);}

    @GetMapping("meteostations/station")
    List<MeteostationResponseModel> byParam(
            @RequestParam(value = "station_name", required = false, defaultValue = "") String stationName,
            @RequestParam(value = "station_longitude", required = false) Double stationLongitude,
            @RequestParam(value = "station_latitude", required = false) Double stationLatitude,
            @RequestParam(value = "station_country", required = false, defaultValue = "") String stationCountry
    ){
        return meteostationsService.byParam(stationName, stationLongitude, stationLatitude, stationCountry);
    }
}
