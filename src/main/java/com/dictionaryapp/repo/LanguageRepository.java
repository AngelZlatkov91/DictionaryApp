package com.dictionaryapp.repo;

import com.dictionaryapp.model.Language;
import com.dictionaryapp.model.enums.LanguageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    Language findByName(LanguageName name);



}
