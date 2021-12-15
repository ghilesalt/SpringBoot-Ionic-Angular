package com.example.demo.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="UTILISATEUR")
public class User {

    @Id
    @SequenceGenerator(
        
        name = "user_sequence",
        sequenceName = "user_sequence",
        allocationSize = 1
    )

    @GeneratedValue(

        strategy = GenerationType.SEQUENCE,
        generator = "user_sequence"
    
    )
    private Long id;
    private String username;
    private String mail;
    private String password;

    public User(){
        
    }

    public User(Long id, String username, String mail, String password){

        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public User(String username, String mail, String password){
        
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }


    public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return " Utilisateur{ " +
                " Id= " + id +
                ", Username='" + username + '\'' +
                ", Mail='" + mail + '\'' +
                ", Password='" + password +
                '}';
    }
}
