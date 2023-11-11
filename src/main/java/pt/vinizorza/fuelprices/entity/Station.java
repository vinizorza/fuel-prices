package pt.vinizorza.fuelprices.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pt.vinizorza.fuelprices.client.response.StationResponse;
import pt.vinizorza.fuelprices.util.CurrencyFormatter;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
public class Station {

    private Integer id;
    private String name;
    private String type;
    private String city;
    private BigDecimal price;
    private String brand;
    private String fuel;
    private String lastUpdate;
    private String district;
    private String address;
    private String locality;
    private String postalCode;
    private Double latitude;
    private Double longitude;
    private Double distance;

    private static Station from(StationResponse response){
        return Station.builder()
                .id(response.getId())
                .name(response.getNome())
                .type(response.getTipoPosto())
                .city(response.getMunicipio())
                .price(CurrencyFormatter.toBigDecimal(response.getPreco()))
                .brand(response.getMarca())
                .fuel(response.getCombustivel())
                .lastUpdate(response.getDataAtualizacao())
                .district(response.getDistrito())
                .address(response.getMorada())
                .locality(response.getLocalidade())
                .postalCode(response.getCodPostal())
                .latitude(response.getLatitude())
                .longitude(response.getLongitude())
                .build();
    }

    public static List<Station> from(List<StationResponse> response){
        return response.stream().map(Station::from).collect(Collectors.toList());
    }

}
