
package pl.altkom.komis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.altkom.komis.entity.Client;

/**
 *
 * @author mgasior
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
