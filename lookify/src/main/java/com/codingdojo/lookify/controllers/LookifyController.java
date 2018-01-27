package com.codingdojo.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.lookify.models.LookifyModel;
import com.codingdojo.lookify.servives.LookifyService;

@Controller
@RequestMapping("/")
public class LookifyController { 
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	@RequestMapping("")
	public String index() {
		return "index";
	}
	@RequestMapping("dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", lookifyService.all());
		return "dashboard";
	}
	@RequestMapping("songs/{id}")
	public String songs(@PathVariable("id") long id,Model model){
		model.addAttribute("song",lookifyService.findById(id));
		return "song";
	}
	
	@RequestMapping("songs/new")
	public String newSong(Model model){
		model.addAttribute("song",new LookifyModel());
		return "new";
	}
	
	@PostMapping("songs/new")
	public String create(@Valid @ModelAttribute("song") LookifyModel song,BindingResult res,RedirectAttributes flash){
		if(res.hasErrors()){
			flash.addFlashAttribute("errs",res.getAllErrors());
			return "redirect:/songs/new";
		}else{
			lookifyService.create(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("songs/delete/{id}")
	public String destroy(@PathVariable("id") long id){
		lookifyService.destroy(id);
		return "redirect:/dashboard";
	}
		
	@PostMapping("/search")
	public String search(@RequestParam(value="artist") String artist,Model model){
		model.addAttribute("songs",lookifyService.findByArtist(artist));
		return "search";
	}
	
	@RequestMapping("/songs/topTen")
	public String topTen(Model model){
		model.addAttribute("songs",lookifyService.topTen());
		return "topTen";
	}
}
