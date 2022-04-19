package bearcation.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import net.sf.ehcache.Cache;
//import net.sf.ehcache.CacheManager;
//import net.sf.ehcache.Element;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import bearcation.model.Park;
//
//import java.util.Arrays;
//import java.util.List;

//@Service
//public class NPService {
//  private String baseUrl = "https://developer.nps.gov/api/v1/";
//  private String api_key = "api_key=os9gdUMtfjWN14L4zo5a33m7m4beCQAC1xrZAjh9";
//  private String url = baseUrl + "parks?limit=500&" + api_key;
//  private CacheManager cm = null;
//  private Cache c = null;
//
//  public NPService() {
//    cm = CacheManager.getInstance();
//    cm.addCache("park cache");
//    c = cm.getCache("park cache");
//  }
//
//  //@Autowired
//  //RestTemplate restTemplate;
//
//  // TODO: Remove Later
//  public String getTest(){
//    return url;
//  }
//
//  public ResponseEntity<String> getParks(){
//    // Check cache for data?
//    ResponseEntity<String> resp;
//
//    // If, data is NOT in cache already
//    if (!c.isKeyInCache("park data")) {
//
//      // GET request on data
//      RestTemplate restTemplate = new RestTemplate();
//      resp = restTemplate.getForEntity(url, String.class);
//
//      // Cache it
//      Element e = new Element("park data", resp);
//      c.put(e);
//
//    } else {
//
//      // Otherwise, IF the data is already cached, get it from cache
//      Element e = c.get("park data");
//      resp = (ResponseEntity<String>) e.getObjectValue();
//    }
//
//    return resp;
//
//    // Here is some commented code I didn't want to delete in case it's important
//    // It was on the line after restTemplate.getFo...
//
//    //Object[] parks = restTemplate.getForObject(url, Object[].class);
//
//    //return Arrays.asList(parks);
//  }
//}
