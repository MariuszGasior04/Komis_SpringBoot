/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.altkom.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author mgasior
 */
@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotBlank(message = "Firstname is mandatory")
    @Column(name = "name")
    private String name;

    @Column(name = "mail")
    private String mail;
    
    @Column(name = "phone_nr")
    private int poneNumber;

    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getPoneNumber() {
        return poneNumber;
    }

    public void setPoneNumber(int poneNumber) {
        this.poneNumber = poneNumber;
    }
    
    
}