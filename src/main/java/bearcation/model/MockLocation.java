package bearcation.model;

import lombok.Data;

@Data
public class MockLocation {
    private String fullName;
    private String id;
    private String description;
    private String name;
    private Double latitude;
    private Double longitude;
    private Activity[] activities;
}
