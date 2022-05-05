package bearcation.service;

import bearcation.model.dto.LocationDTO;
import bearcation.model.dto.UserDTO;
import bearcation.model.entities.Location;
import bearcation.model.entities.User;
import bearcation.model.requests.CreateAccountRequest;
import bearcation.model.requests.ForgotPasswordRequest;
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
        return userRepository.findByEmailAndPasswordAndRole(loginRequest.getEmail(), loginRequest.getPassword(), loginRequest.getRole()).map(UserDTO::new).orElse(null);
    }

    public UserDTO createAccount(CreateAccountRequest createAccountRequest) {
        return new UserDTO(userRepository.save(new User(createAccountRequest.getEmail(), createAccountRequest.getPassword(), createAccountRequest.getFirstName(), createAccountRequest.getLastName(), createAccountRequest.getRole())));
    }

    public UserDTO editAccount(UserDTO editAccountRequest) {
        User user = userRepository.findUserById(editAccountRequest.getId()).get();
        user.setFirstName(editAccountRequest.getFirstName());
        user.setLastName(editAccountRequest.getLastName());
        user.setEmail(editAccountRequest.getEmail());
        return new UserDTO(userRepository.save(user));
    }


    public UserDTO findByFirstNameAndEmail(ForgotPasswordRequest forgotPasswordRequest) {
        return this.userRepository.findByFirstNameAndEmail(forgotPasswordRequest.getFirst(), forgotPasswordRequest.getEmail()).map(UserDTO::new).orElse(null);
    }

    public UserDTO updatePassword(ForgotPasswordRequest forgotPasswordRequest) {
        User user = this.userRepository.findByFirstNameAndEmail(forgotPasswordRequest.getFirst(), forgotPasswordRequest.getEmail()).get();
        user.setPassword(forgotPasswordRequest.getPassword());
        return new UserDTO(userRepository.save(user));
    }
}
