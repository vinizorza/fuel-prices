package pt.vinizorza.fuelprices.client.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DgegFuelResponse implements Serializable {
    private String status;
    private String mensagem;
    private List<FuelResponse> resultado;
}
