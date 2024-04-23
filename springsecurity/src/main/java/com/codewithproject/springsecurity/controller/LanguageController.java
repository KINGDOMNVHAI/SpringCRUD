package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.entities.Language;
import com.codewithproject.springsecurity.services.impl.LanguageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public/language")
@RequiredArgsConstructor
public class LanguageController {

    @Autowired
    private LanguageServiceImpl langServiceImpl;

    @GetMapping("/{codeLang}")
    public Language getLangByCode(@PathVariable String codeLang) {
        Language lang = new Language();
        try {
            lang = langServiceImpl.getLangByCode(codeLang);
        } catch (Exception e) {

        }
        return lang;
    }
}
