/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.altkom.model.Person;
import pl.altkom.repository.PersonRepository;

/**
 *
 * @author mgasior
 */
@Service
public class PersonService {
    @Autowired
    private PersonRepository repo;
    
    public List<Person> listAll(){
        return repo.findAll();
    }
    
    public void save(Person person){
        repo.save(person);
    }
    
    public Person get(Long id){
        return repo.findById(id).get();
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
}
    