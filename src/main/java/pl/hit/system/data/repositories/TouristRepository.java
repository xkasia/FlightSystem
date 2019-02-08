package pl.hit.system.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.hit.system.data.model.Tourist;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {
}
