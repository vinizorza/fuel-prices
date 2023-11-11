package pt.vinizorza.fuelprices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.vinizorza.fuelprices.client.DgegClient;
import pt.vinizorza.fuelprices.client.response.StationResponse;
import pt.vinizorza.fuelprices.entity.Station;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    @Autowired
    private DgegClient client;

    public List<Station> getStations(final double latitude,
                                     final double longitude,
                                     final Integer radius,
                                     final String fuelId){

        final List<StationResponse> response = client.getStations(fuelId);

        if(response == null)
            return List.of();

        final List<Station> stations = Station.from(response);

        stations.forEach(s -> s.setDistance(distance(latitude, longitude, s.getLatitude(), s.getLongitude())));

        return stations.stream()
                .filter(s -> s.getDistance() <= radius)
                .sorted(Comparator.comparing(Station::getPrice))
                .collect(Collectors.toList());
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) +
                Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;

        return (dist);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

}
