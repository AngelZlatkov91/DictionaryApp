package com.dictionaryapp.model;
import com.dictionaryapp.model.DTo.WordAddDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name ="words")
public class Word extends BaseEntity{
    @Column(nullable = false)
    @Size(min = 2,max = 40)
    @NotBlank
    private String term;
    @Column(nullable = false)
    @Size(min = 2,max = 80)
    @NotBlank
    private String translation;
    @Column
    @Size(min = 2,max = 200)
    private String example;
    @Column (nullable = false)
    @PastOrPresent
    private LocalDate date;
    @ManyToOne
    private Language language;
    @ManyToOne
    private User user;

    public  Word (){}

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addData(Language language, Optional<User> user, WordAddDTO wordAddDTO) {
       this.term = wordAddDTO.getTerm();
       this.translation = wordAddDTO.getTranslation();
       this.example = wordAddDTO.getExample();
       this.date = wordAddDTO.getInputDate();
       this.language = language;
       this.user = user.get();
    }
}
