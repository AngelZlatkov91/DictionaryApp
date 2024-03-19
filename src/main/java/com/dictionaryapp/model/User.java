package com.dictionaryapp.model;

import com.dictionaryapp.model.DTo.UserRegistrationDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(nullable = false,unique = true)
    @Size(min = 3,max = 20)
    @NotBlank
    private String username;
    @Column (nullable = false)
    @NotBlank
    private String password;
    @Column(unique = true,nullable = false)
    @Email
    @NotBlank
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<Word> addedWords;

    public User() {
        this.addedWords = new HashSet<>();
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Set<Word> getAddedWords() {
        return addedWords;
    }


    public void setAddedWords(Set<Word> addedWords) {
        this.addedWords = addedWords;
    }


}
