package com.example.demo.configs;

import com.example.demo.models.Language;
import com.example.demo.service.interfaces.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class DataInitializer {
    private final LanguageService languageService;

    @PostConstruct
    private void init() {
        if (languageService.getAllLanguage().size() != 0) {
            return;
        }

        Language l1 = new Language();
        l1.setName("Java");
        l1.setDescription("Good old lang");
        l1.setRaiting(1);
        languageService.addLanguage(l1);

        Language l2 = new Language(2L, "C#", "analog java", 2);
        languageService.addLanguage(l2);

        Language l3 = new Language(3L, "python", "simple, slow", 3);
        languageService.addLanguage(l3);

        Language l4 = new Language(4L, "js", "ugly, he all", 4);
        languageService.addLanguage(l4);
    }
}
