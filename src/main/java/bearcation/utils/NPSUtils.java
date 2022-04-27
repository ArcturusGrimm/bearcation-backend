package bearcation.utils;

import bearcation.model.requests.NationalPark;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class NPSUtils {
    public List<NationalPark> getNationalParks(){
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL("https://developer.nps.gov/api/v1/parks?limit=500&api_key=qBr4jhaew3bhpjs93sLuAmKBfjBUkhf935dop8a9");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(2000);
            con.setReadTimeout(2000);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            JsonNode rootNode = mapper.readTree(content.toString());
            return Arrays.asList(mapper.readValue(rootNode.get("data").toString(), NationalPark[].class));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
