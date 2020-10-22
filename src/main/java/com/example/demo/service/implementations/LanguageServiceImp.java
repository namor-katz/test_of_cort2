package com.example.demo.service.implementations;

import com.example.demo.models.Language;
import com.example.demo.repository.LanguageRepository;
import com.example.demo.service.interfaces.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImp implements LanguageService {

    private final LanguageRepository languageRepository;

    @Override
    public List<Language> getAllLanguage() {
        return languageRepository.findAll();
    }

    @Override
    public Language findLanguageByName(String name) {
        return languageRepository.findLanguageByName(name);
    }

    @Override
    public void addLanguage(Language language) {
        languageRepository.save(language);
    }

    @Override
    public void updateLanguage(Language language) {
        Language languageUpdate = findLanguageByName(language.getName());
        languageUpdate.setRaiting(language.getRaiting());
        languageUpdate.setDescription(language.getDescription());
        languageRepository.save(languageUpdate);
    }

    @Override
    public void deleteLanguage(long id) {
        languageRepository.deleteById(id);
    }
}
