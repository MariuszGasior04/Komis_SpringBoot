
package pl.altkom.komis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.altkom.komis.entity.Trip;

/**
 *
 * @author mgasior
 */
public interface TripRepository extends JpaRepository<Trip, Long>{
    
}
