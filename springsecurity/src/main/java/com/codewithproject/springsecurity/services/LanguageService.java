package com.codewithproject.springsecurity.services;

import com.codewithproject.springsecurity.entities.Language;

import java.util.List;

public interface LanguageService {
    void truncateLanguages();

    List<Language> seederLanguages();

    Language getLangByCode(String codeLang);
}
