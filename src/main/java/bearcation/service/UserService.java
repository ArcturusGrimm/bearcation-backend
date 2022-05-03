package bearcation.service;

import bearcation.model.dto.LocationDTO;
import bearcation.model.dto.UserDTO;
import bearcation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO findUserById(Long id) {
        return userRepository.findUserById(id).map(UserDTO::new).orElse(null);
    }
}
