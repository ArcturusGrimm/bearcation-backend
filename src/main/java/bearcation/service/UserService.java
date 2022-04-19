package bearcation.service;

import bearcation.model.User;
import bearcation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    //Transactional(readOnly=true)
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public List<User> create(){
        User user = new User("123456", "John");
        List<User> users = new ArrayList<User>();
        List<User> savedUsers = new ArrayList<User>();

        users.add(user);
        Iterable<User> itrStudents=userRepository.saveAll(users);
        itrStudents.forEach(savedUsers::add);
        return savedUsers;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }

    public User userById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public User userByUsernameAndPassword(User u) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
        return optionalUser.orElse(null);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

}
