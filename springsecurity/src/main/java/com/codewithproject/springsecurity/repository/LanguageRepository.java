package com.codewithproject.springsecurity.repository;

import com.codewithproject.springsecurity.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE languages", nativeQuery = true)
    void truncateTable();

    @Query(value = "SELECT l.* "
            + " FROM languages l "
            + " WHERE l.id_lang = :idLang", nativeQuery = true)
    Optional<Language> getLangById(Integer idLang);

    @Query(value = "SELECT l.* "
            + " FROM languages l "
            + " WHERE l.code_lang = :codeLang", nativeQuery = true)
    Optional<Language> getLangByCode(String codeLang);
}
