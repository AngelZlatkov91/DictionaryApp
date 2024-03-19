package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.DTo.AllWordsDTO;
import com.dictionaryapp.model.DTo.WordAddDTO;
import com.dictionaryapp.model.DTo.WordDTO;
import com.dictionaryapp.model.Language;
import com.dictionaryapp.model.User;
import com.dictionaryapp.model.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final LoginUser loginUser;
     @Autowired
    public WordServiceImpl(WordRepository wordRepository, LanguageRepository languageRepository, UserRepository userRepository, LoginUser loginUser) {
        this.wordRepository = wordRepository;
         this.languageRepository = languageRepository;
         this.userRepository = userRepository;
         this.loginUser = loginUser;
    }


    @Override
    public void viewAll(WordAddDTO wordAddDTO) {
        Language language = this.languageRepository.findByName(wordAddDTO.getLanguage());
        Optional<User> user = this.userRepository.findByUsername(loginUser.getUsername());
        Word word = new Word();
        if (user.isPresent()) {
            word.addData(language, user, wordAddDTO);
            this.wordRepository.save(word);
        }
    }

    @Override
    public AllWordsDTO viewAll() {
        return new AllWordsDTO(addGermanWord(),addSpanishWord(),addItalianWord(),addFrenchWord());

    }

    @Override
    public void remove(Long id) {
        this.wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        this.wordRepository.deleteAll();
    }

    @Override
    public Long count() {
        return this.wordRepository.count();
    }

    private Set<WordDTO> addGermanWord(){
          Set<WordDTO> germanWord = new HashSet<>();
        this.wordRepository.findAllByLanguageName(LanguageName.GERMAN)
                 .forEach(word -> {
                     WordDTO wordDTO = new WordDTO(word);
                     germanWord.add(wordDTO);
                 });
        return germanWord;
    }
    private Set<WordDTO> addSpanishWord(){
        Set<WordDTO> spanishWord = new HashSet<>();
        this.wordRepository.findAllByLanguageName(LanguageName.SPANISH)
                .forEach(word -> {
                    WordDTO wordDTO = new WordDTO(word);
                    spanishWord.add(wordDTO);
                });
        return spanishWord;
    }
    private Set<WordDTO> addItalianWord(){
        Set<WordDTO> italianWords = new HashSet<>();
        this.wordRepository.findAllByLanguageName(LanguageName.ITALIAN)
                .forEach(word -> {
                    WordDTO wordDTO = new WordDTO(word);
                    italianWords.add(wordDTO);
                });
        return italianWords;
    }
    private Set<WordDTO> addFrenchWord(){
        Set<WordDTO> frenchWords = new HashSet<>();
        this.wordRepository.findAllByLanguageName(LanguageName.FRENCH)
                .forEach(word -> {
                    WordDTO wordDTO = new WordDTO(word);
                    frenchWords.add(wordDTO);
                });
        return frenchWords;
    }



}
