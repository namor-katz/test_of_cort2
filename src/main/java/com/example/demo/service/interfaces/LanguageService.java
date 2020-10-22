package com.example.demo.service.interfaces;

import com.example.demo.models.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAllLanguage();
    Language findLanguageByName(String name);
    void addLanguage(Language language);
    void updateLanguage (Language language);
    void deleteLanguage(long id);
}
