package bearcation.controller;

import bearcation.model.dto.LocationDTO;
import bearcation.model.entities.Location;
import bearcation.model.requests.CreateLocationRequest;
import bearcation.model.requests.FindLocationRequest;
import bearcation.service.AccountService;
import bearcation.service.LocationService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LocationControllerTest {
    @Autowired
    MockMvc mockMvc;

    LocationService locationService = mock(LocationService.class);

    CreateLocationRequest createLocationRequest;
    FindLocationRequest findLocationRequest;
    LocationDTO locationDTO;
    Location location;

    @BeforeEach
    public void setUp(){
        Set<String> activities = new HashSet<String>();
        activities.add("hiking");
        createLocationRequest.setActivities(activities);
        createLocationRequest.setAddress("Address");
        createLocationRequest.setDescription("Description");
        createLocationRequest.setLongitude(10.0);
        createLocationRequest.setLatitude(11.0);
        createLocationRequest.setName("Name");
        createLocationRequest.setOwnerId((long)123);
        createLocationRequest.setPrice(50.0);

        //location = new Location("Name", "Address", "Description", 50.0, 11.0, 10.0);
        location = new Location("Name",  "Description", activities);
        locationDTO = new LocationDTO(location);

        List<String> list = new ArrayList<String>();
        findLocationRequest.setActivities(list);
        findLocationRequest.setPrice(50.5);

    }

    @DisplayName("createLocation test")
    @Test
    public void createLocationTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/location/createLocation")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"ownerId\":\"1\",\"name\":\"new park\",\"address\":\"Waco\"," +
                        "\"description\":\"new location\",\"price\":\"50\",\"latitude\":\"50.0\"," +
                        "\"longitude\":\"60.0\",\"activities\":[\"hiking\"]}"))
                .andExpect(status().isOk());
    }

    @DisplayName("findLocationById test")
    @Test
    public void findLocationByIdTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/location/search/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("new park"));
    }

    @DisplayName("findLocationByName test")
    @Test
    public void findLocationByNameTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/location/search/name/newpark"))
                .andExpect(status().isOk());
    }

    @DisplayName("loadParks test")
    @Test
    public void loadParksTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/location/loadParks"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
    }

    @DisplayName("findAllActivities test")
    @Test
    public void findAllActivitiesTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/location/activities"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]").value("Road Biking"));
    }

}
