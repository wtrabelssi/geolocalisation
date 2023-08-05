package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Reclamations;
import com.example.demo.repo.ReclamationsRepository;

@Controller
public class DataController {
	@Autowired
	private ReclamationsRepository reclamationsRepository;
	List<String> knownBaladia = Arrays.asList("wissem", "tunis", "ariana","manouba");
	@RequestMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("reclamation", new Reclamations(0, 0, null, null, 0));
		return"index";
	}
	
	@PostMapping("/reclamations")
	public String getReclamationsByBaladia(@RequestParam String baladia, Model model) {
	    if (!knownBaladia.contains(baladia)) {
	        // If the user input does not match any of the known baladia, display an error message.
	        model.addAttribute("errorMessage", "Invalid baladia");
	        return "error-page";
	    }

	    // If the user input matches a known baladia, retrieve the corresponding reclamations from the database.
	    List<Reclamations> reclamations = reclamationsRepository.findByLocalisation(baladia);

	    // Pass the list of reclamations to the view for display.
	    model.addAttribute("reclamations", reclamations);
	    return "reclamations";
	}
	
}
