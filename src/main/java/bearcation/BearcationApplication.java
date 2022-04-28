package bearcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import bearcation.model.Location;
import bearcation.model.Review;
import bearcation.model.User;
import bearcation.repository.LocationRepository;
import bearcation.repository.ReviewRepository;
import bearcation.repository.UserRepository;

@SpringBootApplication
public class BearcationApplication implements CommandLineRunner {
  public static void main(String[] args){
    SpringApplication.run(BearcationApplication.class, args);
  }

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private LocationRepository locationRepository;

  @Autowired
  private ReviewRepository reviewRepository;

  @Override
  public void run(String...args) throws Exception{
    this.instantiateDatabase();
  }

  private void instantiateDatabase(){
    User userTest = new User("testUser", "testPassword");
    Location testLocation = new Location(userTest, "locationName", "testAddress", "testDetails");
    this.userRepository.save(userTest);
    this.locationRepository.save(testLocation);
    this.reviewRepository.save(new Review(5.0, "testDescription", userTest, testLocation));
  }
}
