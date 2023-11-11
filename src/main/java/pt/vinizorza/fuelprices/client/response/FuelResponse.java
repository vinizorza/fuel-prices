package pt.vinizorza.fuelprices.client.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class FuelResponse implements Serializable {
    private Integer Id;
    private String Descritivo;
    private String UnidadeMedida;
}
