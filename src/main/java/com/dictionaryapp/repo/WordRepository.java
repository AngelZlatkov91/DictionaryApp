package com.dictionaryapp.repo;

import com.dictionaryapp.model.Word;
import com.dictionaryapp.model.enums.LanguageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface WordRepository extends JpaRepository<Word,Long> {

    Set<Word> findAllByLanguageName(LanguageName name);
}
