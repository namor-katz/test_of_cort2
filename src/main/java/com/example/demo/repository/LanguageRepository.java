package com.example.demo.repository;

import com.example.demo.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    @Query("select l from Language l where lower(l.name) = lower(:name)")
    Language findLanguageByName(@Param("name") String name);

}
