
package pl.altkom.komis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.altkom.komis.entity.Car;

/**
 *
 * @author mgasior
 */
public interface CarRepository extends JpaRepository<Car, Long>{
    
}
