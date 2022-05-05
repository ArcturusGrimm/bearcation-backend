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
    User user = null;
    UserRepository repository = mock(UserRepository.class);
    UserService service = new UserService(repository);

    @Before
    public void setup(){
        user = new User();
        user.setId(123L);
        user.setFirstName("name");
        user.setLastName("name2");
        user.setRole("Customer");
        user.setPassword("abc");
        user.setEmail("abc@gmail.com");
    }

    @Test
    public void testSearchById(){
        when(repository.findById((long)123)).thenReturn(Optional.ofNullable(user));
        assertEquals(user, service.findUserById(user.getId()));
    }

    @Test
    public void testSearchByUser(){
        when(repository.findByEmailAndPasswordAndRole("abc@gmail.com", "abc", "Customer").orElse(null));
        assertEquals(user, repository.findByEmailAndPasswordAndRole("abc@gmail.com", "abc", "Customer"));
    }
}
