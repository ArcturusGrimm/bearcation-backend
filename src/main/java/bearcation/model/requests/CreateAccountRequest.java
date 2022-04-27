package bearcation.model.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccountRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
