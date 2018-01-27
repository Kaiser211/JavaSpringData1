package com.codingdojo.lookify.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.lookify.models.LookifyModel;

public interface LookifyRepository extends CrudRepository<LookifyModel, Long> {
	public ArrayList<LookifyModel> findByArtistContaining(String search);
	public ArrayList<LookifyModel> OrderByRatingDesc();
	

}
