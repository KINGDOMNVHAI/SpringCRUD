package com.codewithproject.springsecurity.seeder;

import com.codewithproject.springsecurity.entities.Language;
import com.codewithproject.springsecurity.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LanguageSeeder {

    @Autowired
    public LanguageRepository langRepo;

    public List<Language> seederLanguages() {
        List<Language> result = new ArrayList<>();
        try {
            Language langVI = new Language();
            langVI.setNameLang("Vietnam");
            langVI.setCodeLang("vi");
            langVI.setLocaleLang("Vietnam");
            langRepo.save(langVI);
            result.add(langVI);

            Language langAmerican = new Language();
            langAmerican.setNameLang("English");
            langAmerican.setCodeLang("en");
            langAmerican.setLocaleLang("American");
            langRepo.save(langAmerican);
            result.add(langAmerican);

            Language langJP = new Language();
            langJP.setNameLang("Japanese");
            langJP.setCodeLang("jp");
            langJP.setLocaleLang("Japanese");
            langRepo.save(langJP);
            result.add(langJP);

            Language langKR = new Language();
            langKR.setNameLang("Korea");
            langKR.setCodeLang("kr");
            langKR.setLocaleLang("Korea");
            langRepo.save(langKR);
            result.add(langKR);

        } catch (Exception ex) {
            return result;
        }
        return result;
    }
}
