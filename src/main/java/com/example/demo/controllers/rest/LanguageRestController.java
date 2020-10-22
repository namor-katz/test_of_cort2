package com.example.demo.controllers.rest;

import com.example.demo.models.Language;
import com.example.demo.service.interfaces.LanguageService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping()
public class LanguageRestController {

    private final LanguageService languageService;

    @GetMapping(value = {"language", "/language/{name}"})
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

    @PostMapping(value = "/language", consumes = {"application/json"})
    public ResponseEntity<Language> createNewLanguage(@RequestBody Language l) {
        languageService.addLanguage(l);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    @ApiResponses(value = {@ApiResponse(code = 201, message = "ok")})
    @DeleteMapping("/language/{name}")
    public Map<String, String> deleteLanguage(@PathVariable(name = "name") String name) {
        HashMap<String, String> map = new HashMap<>();
        if(name == null) {
            map.put("state", "not found");
        }
        else {
            Language l = languageService.findLanguageByName(name);
            Long id = l.getId();
            languageService.deleteLanguage(id);
            map.put("state", "ok");
        }
        return map;
    }
}
