package bearcation.controller;


import bearcation.model.dto.LocationDTO;
import bearcation.model.dto.ReviewDTO;
import bearcation.model.requests.*;
import bearcation.service.LocationService;
import bearcation.utils.NPSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/location")
public class LocationController {
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }
    @PostMapping("/createLocation")
    public LocationDTO createLocation(@RequestBody CreateLocationRequest createLocationRequest) {
        return locationService.createLocation(createLocationRequest);
    }

    @PatchMapping("/editLocation")
    public LocationDTO editLocation(@RequestBody LocationDTO editLocationRequest) {
        return locationService.editLocation(editLocationRequest);
    }

    @GetMapping("/delete/{id}")
    public void deleteLocationById(@PathVariable Long id){
        locationService.deleteLocationById(id);
    }

    @GetMapping("/search/{id}")
    public LocationDTO findLocationById(@PathVariable Long id){
        return locationService.findLocationById(id);
    }

    @GetMapping("/search/name/{name}")
    public LocationDTO findLocationByName(@PathVariable String name){
        return locationService.findLocationByName(name);
    }
    @GetMapping("/loadParks")
    public List<LocationDTO> loadParks() {
        NPSUtils parks = new NPSUtils();
        List<NationalPark> npsParks = parks.getNationalParks();
        for(NationalPark np : npsParks){
            Double entranceFee = 0.0;
            List<Double> fees = Arrays.stream(np.getEntranceFees()).map(EntranceFees::getCost).collect(Collectors.toList());
            Set<String> activities = Arrays.stream(np.getActivities()).map(Activity::getName).collect(Collectors.toSet());
            entranceFee = (fees.isEmpty()) ? 0.0 : fees.get(0);
            System.out.println(fees.toString());

            CreateLocationRequest createLocationRequest =
                    new CreateLocationRequest(null, np.getName(), "",
                            np.getDescription(), entranceFee,
                            np.getLatitude(), np.getLongitude(), activities);
            locationService.createLocation(createLocationRequest);
        }
        return locationService.findAllLocations();
    }
    @GetMapping("/locations")
    public List<LocationDTO> findAllLocations() {
        return locationService.findAllLocations();
    }
    @GetMapping("/activities")
    public Set<String> findAllActivities() {
        return locationService.findAllActivities();
    }

    @PostMapping("/search")
    public List<LocationDTO> getLocationsByAlgorithm(@RequestBody FindLocationRequest findLocationRequest){
        List<LocationDTO> recommendation = locationService.findAllLocations();
        Collections.shuffle(recommendation);
        return recommendation.stream().limit(3).collect(Collectors.toList());
    }
    @PostMapping("/search2")
    public List<LocationDTO> getLocationsByAlgorithm2(@RequestBody FindLocationRequest findLocationRequest){
        return locationService.getRecommendedLocations(findLocationRequest.getLatitude(), findLocationRequest.getLongitude(),
        findLocationRequest.getPrice(), findLocationRequest.getActivities().stream().collect(Collectors.toSet()));
    }

    @GetMapping("/search/user/{id}")
    public List<LocationDTO> findReviewsByOwner(@PathVariable Long id){
        return locationService.findReviewsByOwner(id);
    }

}