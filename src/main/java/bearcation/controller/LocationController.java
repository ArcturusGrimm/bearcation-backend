package bearcation.controller;


import bearcation.model.dto.LocationDTO;
import bearcation.model.requests.Activity;
import bearcation.model.requests.CreateLocationRequest;
import bearcation.model.requests.FindLocationRequest;
import bearcation.model.requests.NationalPark;
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
            Set<String> activities = Arrays.stream(np.getActivities()).map(Activity::getName).collect(Collectors.toSet());
            CreateLocationRequest createLocationRequest =
                    new CreateLocationRequest(null, np.getName(), "",
                            np.getDescription(), 0.0,
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
        return recommendation.stream().limit(10).collect(Collectors.toList());
//        return locationService.getRecommendedLocations(findLocationRequest.getLatitude(), findLocationRequest.getLongitude(),
//                findLocationRequest.getPrice(), findLocationRequest.getActivities().stream().collect(Collectors.toSet()));
    }

//     @GetMapping("/search")
//     public List<LocationDTO> getLocationsByAlgorithm(){
//         List<LocationDTO> recommendation = locationService.findAllLocations();
//         Collections.shuffle(recommendation);
//         return recommendation.stream().limit(3).collect(Collectors.toList());
//          return locationService.getRecommendedLocations(findLocationRequest.getLatitude(), findLocationRequest.getLongitude(),
//               findLocationRequest.getPrice(), findLocationRequest.getActivities().stream().collect(Collectors.toSet()));
// }

//    @GetMapping("/search/{latitude}/{longitude}/{price}/{activities}")
//    public List<LocationDTO> getLocationsByAlgorithm(@PathVariable Double latitude, @PathVariable Double longitude,
//                                                     @PathVariable Double price, @PathVariable Activity[] activities){
//        return locationService.getRecommendedLocations(latitude, longitude, price, activities);
//    }


//    @GetMapping("/search/{latitude}/{longitude}/{price}")
//    public List<LocationDTO> getLocationsByAlgorithm(@PathVariable Double latitude, @PathVariable Double longitude,
//                                                 @PathVariable Double price){
//    return locationService.getRecommendedLocations(latitude, longitude, price, null);
//    }

}