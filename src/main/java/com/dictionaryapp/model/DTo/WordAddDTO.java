package com.dictionaryapp.model.DTo;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WordAddDTO {
    @NotBlank
    @Size(min = 2,max = 40, message = "The term length must be between 2 and 40 characters!")
    private String term;
    @NotBlank
    @Size(min = 2,max = 80, message = "The translation length must be between 2 and 80 characters!")
    private String translation;


    @Size(min = 2,max = 200)
    private String example;


    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputDate;


    private LanguageName language;

    public WordAddDTO (){
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



    public LanguageName getLanguage() {
        return language;
    }

    public void setLanguage(LanguageName language) {
        this.language = language;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }
}
