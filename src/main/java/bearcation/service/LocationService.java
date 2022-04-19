package bearcation.service;

import bearcation.model.User;
import bearcation.model.Location;
import bearcation.model.Review;
import bearcation.repository.UserRepository;
import bearcation.repository.LocationRepository;
import bearcation.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class LocationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Location> getLocations() {
        return this.locationRepository.findAll();
    }

    public Location createLocation(Location location){
        userRepository.save(location.getOwner());
        return locationRepository.save(location);
    }

    public Location getLocationById(long id) {
        Optional<Location> optionalLocation= this.locationRepository.findById(id);
        if (optionalLocation.isPresent()) {
            return optionalLocation.get();
        }
        return null;
    }

    public void deleteLocation(String name) {
        locationRepository.deleteByName(name);
    }

    public void updateLocation(String name, Location location) {
        locationRepository.save(location);
    }
    Integer calculateScore(Location location, Double latitude, Double longitude){
        Double distance = this.calculateDistance(latitude, longitude, location.getLatitude(), location.getLongitude());
        Double cost = location.getPrice();

        Integer score = 0;
        if(distance <= 50) {
            score += 100;
        }else if (distance <= 100) {
            score += 50;
        } else if (distance <= 250) {
            score += 25;
        } else if (distance <= 750) {
            score += 10;
        }

        //score += activityCount < 25 ? activityCount * 2 : 50;

        if (cost <= location.getPrice()) {
            score += 50;
        } else if (cost <= location.getPrice() * 2) {
            score += 25;
        } else if (cost <= location.getPrice() * 3) {
            score += 5;
        }

        return score;

    }
    Double toRad(Double value) {
        return (value * Math.PI) / 180.0;
    }

    Double calculateDistance(Double slat1, Double long1, Double slat2, Double long2) {
        double R = 3950.0; // km
        //not sure if this is actual minus
        double dLat = this.toRad(slat2 - slat1);
        double dLong = this.toRad(long2 - long1);
        double lat1 = this.toRad(slat1);
        double lat2 = this.toRad(slat2);

        double a =
                Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                        Math.sin(dLong / 2) * Math.sin(dLong / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }

    public List<Location> getLocationsByAlgorithm(Double longitude, Double latitude, Double price) {
        List<Location> locations = locationRepository.findAll();

        locations.sort(Comparator.comparingInt(a -> calculateScore(a, latitude, longitude)));
        //locations.sort((a, b) -> Integer.compare(calculateScore(a, latitude, longitude), calculateScore(b, latitude, longitude)));
        return null;
    }
}