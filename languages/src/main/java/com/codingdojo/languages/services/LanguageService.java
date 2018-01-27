package com.codingdojo.languages.services;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService{
	private LanguageRepository  languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
		  this.languageRepository  = languageRepository;
	}
	
	public ArrayList<Language> all(){
		return (ArrayList<Language>)  languageRepository.findAll();
		}
	
	public double count() {
		return languageRepository.count();
	}
	
	public Language getByIndex(long id) {
		System.out.println(languageRepository.countByNameContaining("Java"));
		return languageRepository.findOne(id);
	}
	public void create(Language language) {
		languageRepository.save(language);
	}
	public void update(Language language) {
		languageRepository.save(language);
		}
	
	public void destroy(long id) {
		languageRepository.delete(id);
		
}
	}
