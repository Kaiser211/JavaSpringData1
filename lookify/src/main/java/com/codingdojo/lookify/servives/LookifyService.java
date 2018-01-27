package com.codingdojo.lookify.servives;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.LookifyModel;
import com.codingdojo.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private LookifyRepository lookifyRepository;
	
	public LookifyService(LookifyRepository lookifyRepository) {
		this.lookifyRepository = lookifyRepository;
		}
	public void create(LookifyModel song) {
		lookifyRepository.save(song);
	}
	public void update(LookifyModel song) {
		lookifyRepository.save(song);
	}
	public void destroy(long id) {
		lookifyRepository.delete(id);

}
	public ArrayList<LookifyModel> all(){
		return (ArrayList<LookifyModel>) lookifyRepository.findAll();
	}
	public ArrayList<LookifyModel> findByArtist(String song){
		return (ArrayList<LookifyModel>) lookifyRepository.findByArtistContaining(song);
	}
	public LookifyModel findById(long id) {
		return lookifyRepository.findOne(id);	
	}
	public ArrayList<LookifyModel> topTen(){
		ArrayList<LookifyModel> songs =(ArrayList<LookifyModel>) lookifyRepository.OrderByRatingDesc();
		for(int i=0; i<songs.size(); i++) {
			if(i> 10) {
				songs.remove(i);
			}
		}
		return songs;
	}
}















