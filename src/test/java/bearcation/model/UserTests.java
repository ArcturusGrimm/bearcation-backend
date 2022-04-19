package bearcation.model;
// Feel free to change anything you want here

import bearcation.BearcationApplication;
import bearcation.controller.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.*;
import bearcation.model.*;
import org.mockito.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BearcationController.class)
//@WithMockUser (not working, going to try without this)
public class UserTests {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BearcationController bearcationController;
//
//    User user = new User("password", "test123", 6942069L);
//
//    String exampleUserJson = "{\"id\":\"6942069\",\"password\":\"password\",\"username\":\"test123\"}";
//
//    @Test
//    public void retrieveUser() throws Exception {
//
//        Mockito.when(bearcationController.UserById(6942069L)).thenReturn(user);
//
//        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//                "/user/6942069").accept(
//                MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        String expected = "{id:6942069,password:'password',username:'test123'}";
//
//        JSONAssert.assertEquals(expected, result.getResponse()
//                .getContentAsString(), false);
//
//    }
//
//    @Test
//    public void createUserTest() throws Exception {
//        long id = 12049710259L;
//        User mockUser = new User("neverguessthis", "sickomode");
//        mockUser.setId(id);
//
//        // userService. to respond back with mockCourse
//        Mockito.when(bearcationController.createEmployee(Mockito.any(User.class))).thenReturn(mockUser);
//
//        // Send course as body to /user/12049710259
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/user/12049710259")
//
//                .accept(MediaType.APPLICATION_JSON).content(exampleUserJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/user/12049710259",
//                response.getHeader(HttpHeaders.LOCATION));
//
//    }


}
