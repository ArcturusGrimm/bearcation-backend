package bearcation.service;

import bearcation.model.dto.UserDTO;
import bearcation.model.entities.User;
import bearcation.model.requests.CreateAccountRequest;
import bearcation.model.requests.LoginRequest;
import bearcation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final UserRepository userRepository;

    @Autowired
    AccountService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public UserDTO login(LoginRequest loginRequest) {
        return userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()).map(UserDTO::new).orElse(null);
    }

    public UserDTO createAccount(CreateAccountRequest createAccountRequest) {
        return new UserDTO(userRepository.save(new User(createAccountRequest.getEmail(), createAccountRequest.getPassword(), createAccountRequest.getFirstName(), createAccountRequest.getLastName())));
    }
}
