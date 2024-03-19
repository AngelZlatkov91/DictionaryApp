package com.dictionaryapp.model.DTo;
import java.util.HashSet;
import java.util.Set;

public class AllWordsDTO {
    private Set<WordDTO> allGermanWords;
    private Set<WordDTO> allSpanishWords;
    private Set<WordDTO> allItalianWords;
    private Set<WordDTO> allFrenchWords;

    public AllWordsDTO() {
        this.allGermanWords = new HashSet<>();
        this.allSpanishWords = new HashSet<>();
        this.allItalianWords = new HashSet<>();
        this.allFrenchWords = new HashSet<>();
    }
    public AllWordsDTO (Set<WordDTO> german, Set<WordDTO> spanish, Set<WordDTO> italian, Set<WordDTO> french){
        this();
        this.allGermanWords = german;
        this.allSpanishWords = spanish;
        this.allItalianWords = italian;
        this.allFrenchWords = french;
    }

    public Set<WordDTO> getAllGermanWords() {
        return allGermanWords;
    }

    public void setAllGermanWords(Set<WordDTO> allGermanWords) {
        this.allGermanWords = allGermanWords;
    }

    public Set<WordDTO> getAllSpanishWords() {
        return allSpanishWords;
    }

    public void setAllSpanishWords(Set<WordDTO> allSpanishWords) {
        this.allSpanishWords = allSpanishWords;
    }

    public Set<WordDTO> getAllItalianWords() {
        return allItalianWords;
    }

    public void setAllItalianWords(Set<WordDTO> allItalianWords) {
        this.allItalianWords = allItalianWords;
    }

    public Set<WordDTO> getAllFrenchWords() {
        return allFrenchWords;
    }

    public void setAllFrenchWords(Set<WordDTO> allFrenchWords) {
        this.allFrenchWords = allFrenchWords;
    }
    public int sizeGerman() {
        return  this.allGermanWords.size();
    }
    public int sizeSpanish() {
        return  this.allSpanishWords.size();
    }
    public int sizeItalian() {
        return  this.allItalianWords.size();
    }
    public int sizeFrench() {
        return  this.allFrenchWords.size();
    }
    public int allSize(){
        return sizeGerman() + sizeSpanish() + sizeItalian() + sizeFrench();
    }
}
