package com.dictionaryapp.model;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "languages")
public class Language extends BaseEntity{
    private static final String GERMAN_DESCRIPTION = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
    private static final String SPANISH_DESCRIPTION = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure";
    private static final String FRENCH_DESCRIPTION = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature";
    private static final String ITALIAN_DESCRIPTION = "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";


    @Column(nullable = false,unique = true)
    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private Set<Word> words;

    public Language(){
        this.words = new HashSet<>();
    }

    public LanguageName getName() {
        return name;
    }

    public void setName(LanguageName name) {
        this.name = name;
        setDescription(name);
    }

    public String getDescription() {
        return description;
    }


    public Set<Word> getWords() {
        return words;
    }

    public void setWords(Set<Word> words) {
        this.words = words;
    }
    public void setDescription(LanguageName name) {
        this.description = switch (name) {
            case GERMAN -> GERMAN_DESCRIPTION;
            case SPANISH -> SPANISH_DESCRIPTION;
            case FRENCH -> FRENCH_DESCRIPTION;
            case ITALIAN -> ITALIAN_DESCRIPTION;
        };


    }
}
