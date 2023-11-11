package pt.vinizorza.fuelprices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.vinizorza.fuelprices.client.DgegClient;
import pt.vinizorza.fuelprices.entity.Fuel;

import java.util.List;

@Service
public class FuelService {

    @Autowired
    private DgegClient client;

    public List<Fuel> getFuels(){
        return Fuel.from(client.getFuels());
    }

}
