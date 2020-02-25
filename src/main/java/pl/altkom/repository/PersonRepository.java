/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.altkom.model.Person;

/**
 *
 * @author mgasior
 */
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
