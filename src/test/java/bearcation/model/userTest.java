package bearcation.model;

import bearcation.model.entities.Location;
import bearcation.model.entities.User;
import bearcation.repository.LocationRepository;
import bearcation.repository.UserRepository;
import bearcation.service.LocationService;
import bearcation.service.UserService;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class userTest {
//    User user = null;
//    UserRepository repository = mock(UserRepository.class);
//    UserService service = new UserService();
//
//    @Before
//    public void setup(){
//        user = new User();
//        user.setId(123);
//        user.setUsername("name");
//        user.setPassword("abc");
//    }
//
//    @Test
//    public void testSearchById(){
//        service.setUserRepository(repository);
//        when(repository.findById((long)123)).thenReturn(Optional.ofNullable(user));
//        assertEquals(user, service.userById(user.getId()));
//    }
//
//    @Test
//    public void testSearchByUser(){
//        service.setUserRepository(repository);
//        when(repository.findByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(Optional.ofNullable(user));
//        assertEquals(user, service.userByUsernameAndPassword(user));
//    }
}
