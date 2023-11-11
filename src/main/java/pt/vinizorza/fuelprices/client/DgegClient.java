package pt.vinizorza.fuelprices.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pt.vinizorza.fuelprices.client.response.DgegFuelResponse;
import pt.vinizorza.fuelprices.client.response.DgegStationResponse;
import pt.vinizorza.fuelprices.client.response.FuelResponse;
import pt.vinizorza.fuelprices.client.response.StationResponse;

import java.util.List;

@Component
public class DgegClient {

    @Value("${dgeg-api-url}")
    private String urlApi;

    public List<StationResponse> getStations(final String fuelId){
        RestTemplate restTemplate = new RestTemplate();
        String url = urlApi + "/PesquisarPostos?idsTiposComb=" + fuelId + "&qtdPorPagina=999999&pagina=1";
        DgegStationResponse response = restTemplate.getForObject(url, DgegStationResponse.class);
        return response.getResultado();
    }

    public List<FuelResponse> getFuels(){
        RestTemplate restTemplate = new RestTemplate();
        String url = urlApi + "/GetTiposCombustiveis";
        DgegFuelResponse response = restTemplate.getForObject(url, DgegFuelResponse.class);
        return response.getResultado();
    }

}
