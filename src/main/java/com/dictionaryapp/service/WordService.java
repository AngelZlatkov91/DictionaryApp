package com.dictionaryapp.service;

import com.dictionaryapp.model.DTo.AllWordsDTO;
import com.dictionaryapp.model.DTo.WordAddDTO;

public interface WordService {
     void viewAll(WordAddDTO wordAddDTO);

     AllWordsDTO viewAll();

     void remove (Long id);
     void removeAll();
     Long count();

}
