package bearcation.controller;


import bearcation.model.Activity;
import bearcation.model.MockLocation;
import bearcation.model.User;
import bearcation.service.LocationService;
import bearcation.model.Location;
import bearcation.service.UserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/location")
public class LocationController {


    @Autowired
    private LocationService locationService;

    @Autowired
    private UserService userService;



    @GetMapping("/locations")
    public List<Location> getLocations() {
        //return locationService.getLocations();
        //"https://developer.nps.gov/api/v1/parks?limit=500&api_key=qBr4jhaew3bhpjs93sLuAmKBfjBUkhf935dop8a9"
        StringBuffer content = new StringBuffer();
        try {
            URL url = new URL("https://developer.nps.gov/api/v1/parks?limit=500&api_key=qBr4jhaew3bhpjs93sLuAmKBfjBUkhf935dop8a9");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(2000);
            con.setReadTimeout(2000);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = mapper.readTree(content.toString());
            MockLocation[] mc = mapper.readValue(rootNode.get("data").toString(), MockLocation[].class);
            //List<Location> locations = new ArrayList<>();
            for(MockLocation m: mc){
                Location l = new Location();
                l.setName(m.getName());
                l.setDescription(m.getDescription());
                l.setLatitude(m.getLatitude());
                l.setLongitude(m.getLongitude());
                List<String> activities = new ArrayList<>();
                for(Activity a : m.getActivities()){
                    activities.add(a.getName());
                }
                l.setActivities(activities);
                l.setOwner(userService.userById(1L));
                l.setId(null);
                locationService.createLocation(l);
            }


        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return locationService.getLocations();


    }
    @GetMapping("/search/{id}")
    public Location getLocationById(@PathVariable long id){
        return locationService.getLocationById(id);
    }
    @GetMapping("/search/{longitude}/{latitude}/{price}")
    public List<Location> getLocationsByAlgorithm(@PathVariable Double longitude, @PathVariable Double latitude, @PathVariable Double price){
        return locationService.getLocationsByAlgorithm(longitude, latitude, price);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteLocation(@PathVariable String name){
        locationService.deleteLocation(name);
    }

    @PutMapping("/update/{name}")
    public void updateLocation(@PathVariable String name, @RequestBody Location location){
        locationService.updateLocation(name, location);
    }


    @PostMapping("/addLocation")
    public Location saveLocation(@RequestBody Location location){
        return locationService.createLocation(location);
    }


}
