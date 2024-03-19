package com.dictionaryapp.model.DTo;

import com.dictionaryapp.model.Word;

import java.time.LocalDate;

public class WordDTO {
    private Long id;

    private String term;
    private String translation;
    private String example;
    private LocalDate date;
    private String name;

    public WordDTO(Word word){
        this.id = word.getId();
        this.term = word.getTerm();
        this.translation = word.getTranslation();
        this.example = word.getExample();
        this.date = word.getDate();
        this.name = word.getUser().getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
