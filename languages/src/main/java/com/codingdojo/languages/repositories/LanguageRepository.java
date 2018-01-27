package com.codingdojo.languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Long>{
	Long countByNameContaining(String search);
}