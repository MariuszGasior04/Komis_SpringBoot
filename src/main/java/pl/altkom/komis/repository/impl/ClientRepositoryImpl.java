/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.komis.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.altkom.komis.entity.Client;
import pl.altkom.komis.repository.ClientRepository;

/**
 *
 * @author mgasior
 */
@Service
public class ClientRepositoryImpl{
    
    @Autowired
    private ClientRepository repo;
    
    public List<Client> listAll(){
        return repo.findAll();
    }
    
    public void save(Client client){
        repo.save(client);
    }
    
    public Client get(Long id){
        return repo.findById(id).get();
    }
    
    public void delete(Long id){
        repo.deleteById(id);}
}
