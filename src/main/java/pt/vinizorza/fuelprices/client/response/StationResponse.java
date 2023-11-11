package pt.vinizorza.fuelprices.client.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class StationResponse implements Serializable {
    private Integer Id;
    private String Nome;
    private String TipoPosto;
    private String Municipio;
    private String Preco;
    private String Marca;
    private String Combustivel;
    private String DataAtualizacao;
    private String Distrito;
    private String Morada;
    private String Localidade;
    private String CodPostal;
    private Double Latitude;
    private Double Longitude;
    private Integer Quantidade;
}
