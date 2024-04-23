package com.codewithproject.springsecurity.services.impl;

import com.codewithproject.springsecurity.entities.Language;
import com.codewithproject.springsecurity.repository.LanguageRepository;
import com.codewithproject.springsecurity.seeder.LanguageSeeder;
import com.codewithproject.springsecurity.services.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private LanguageRepository langRepo;

    @Autowired
    private LanguageSeeder langSeeder;

    public void truncateLanguages() {
        langRepo.truncateTable();
    }

    public List<Language> seederLanguages() {
        truncateLanguages();
        return langSeeder.seederLanguages();
    }

    public Language getLangByCode(String codeLang) {
        Language result = new Language();
        Optional<Language> lang = langRepo.getLangByCode(codeLang);
        if (lang.isPresent()) {
            result = lang.get();
        }
        return result;
    }
}
