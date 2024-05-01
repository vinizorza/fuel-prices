package pt.vinizorza.fuelprices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.vinizorza.fuelprices.entity.Fuel;
import pt.vinizorza.fuelprices.service.FuelService;

import java.util.List;

@RestController
@RequestMapping(value = "/fuel")
public class FuelController {

    @Autowired
    private FuelService service;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Fuel>> getFuels() {
        return ResponseEntity.ok(service.getFuels());
    }
}
