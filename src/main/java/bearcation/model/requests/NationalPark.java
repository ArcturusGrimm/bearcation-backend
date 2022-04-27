package bearcation.model.requests;

import bearcation.model.requests.Activity;
import lombok.Data;

@Data
public class NationalPark {
    private String fullName;
    private String id;
    private String description;
    private String name;
    private Double latitude;
    private Double longitude;
    private Activity[] activities;
}
