package bearcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class BearcationApplication {
  public static void main(String[] args){
    SpringApplication.run(BearcationApplication.class, args);
  }
}
