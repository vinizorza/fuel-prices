package pt.vinizorza.fuelprices.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.vinizorza.fuelprices.entity.Station;
import pt.vinizorza.fuelprices.service.StationService;

import java.util.List;

@RestController
@RequestMapping(value = "/station")
public class StationController {

    @Autowired
    private StationService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Station>> getStations(@RequestParam double latitude,
                                                     @RequestParam double longitude,
                                                     @RequestParam @Max(10) @Min(1) Integer radius,
                                                     @RequestParam String fuelId) {
        return ResponseEntity.ok(service.getStations(latitude, longitude, radius, fuelId));
    }
}
