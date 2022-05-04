package bearcation.repository;

import bearcation.model.entities.Location;
import bearcation.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findLocationByName(String name);

    void deleteById(Long id);

    Optional<Location> findLocationById(Long id);

    Optional<List<Location>> findLocationsByOwner(User u);


}