package com.example.demo.controllers.rest;

import com.example.demo.models.Language;
import com.example.demo.service.interfaces.LanguageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = {"/language", "/language/{name}"})
public class LanguageRestController {

    private final LanguageService languageService;

    @GetMapping()
    public List<Language> getLanguage(@PathVariable(required = false) String name) {
        if (name ==  null) {
            return languageService.getAllLanguage();
        }
        else {
            List<Language> ll = new ArrayList<>();
            ll.add(languageService.findLanguageByName(name));
            return ll;
        }
    }

    @PostMapping
    public void Empt() {
        System.out.println("получен запрос post!");
    }

}
