package service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import bearcation.controller.BearcationController;

@Nested
@DisplayName("National Park Service Test")
public class NPServiceTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BearcationController bearcationController;

  @Test
  @DisplayName("Direct API call test")
  public void testAPICall(){
    String url = "https://developer.nps.gov/api/v1/parks?limit=500&api_key=os9gdUMtfjWN14L4zo5a33m7m4beCQAC1xrZAjh9";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
  }

  /*
    TODO: Fix and add functionality later
  @Test
  @DisplayName("API Call using Controller")
  public void testAPICall2(){
    String url = "https://developer.nps.gov/api/v1/parks?limit=500&api_key=os9gdUMtfjWN14L4zo5a33m7m4beCQAC1xrZAjh9";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

    ResponseEntity<String> result = response;

    Mockito.when(bearcationController.getParks()).thenReturn(result);
  }
  */
}
