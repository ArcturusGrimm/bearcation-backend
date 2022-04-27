package bearcation.model.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class FindLocationRequest {
    Double latitude;
    Double longitude;
    Double price;
    List<String> activities;
}
