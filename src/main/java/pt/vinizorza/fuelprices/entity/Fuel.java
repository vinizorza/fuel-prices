package pt.vinizorza.fuelprices.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pt.vinizorza.fuelprices.client.response.FuelResponse;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
public class Fuel {

    private Integer id;
    private String description;
    private String measuringUnit;

    private static Fuel from(FuelResponse response){
        return Fuel.builder()
                .id(response.getId())
                .description(response.getDescritivo())
                .measuringUnit(response.getUnidadeMedida())
                .build();
    }

    public static List<Fuel> from(List<FuelResponse> response){
        return response.stream().map(Fuel::from).collect(Collectors.toList());
    }

}
