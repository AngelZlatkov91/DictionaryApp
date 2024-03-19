package com.dictionaryapp.init;

import com.dictionaryapp.model.Language;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dictionaryapp.Messages.Messages.*;

@Component
public class LanguageSeedData implements CommandLineRunner {

    private final LanguageRepository languageRepository;
        @Autowired
    public LanguageSeedData(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        if (this.languageRepository.count() == 0) {
            List<Language> languages = new ArrayList<>();
            Arrays.stream(LanguageName.values()).forEach(name -> {
                Language language = new Language();
                language.setName(name);
                languages.add(language);
            });
            this.languageRepository.saveAll(languages);
        }
    }
}
