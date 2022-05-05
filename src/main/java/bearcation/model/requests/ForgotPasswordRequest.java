package bearcation.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
@Data
@AllArgsConstructor
public class ForgotPasswordRequest {
        private String first;
        private String email;
        private String password;
}
