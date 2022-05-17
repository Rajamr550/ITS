/*
 * 1.view intevriew members - GET[doubt.............
 * 	CandidateDelegateService
 * 		-call the admin url = [
 * 
 * 
 * 2.view a candidate --- . call back to admin url
 * 
 * 3.give rating
 * 
 * 4.surrender
 * 
 * 
 * 
 */

package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Candidate;
import com.zensar.dto.Interview;
import com.zensar.service.TechService;

@RestController
@RequestMapping("/its-tech")
@CrossOrigin(origins = "*")
public class TechController {

	@Autowired
	TechService techService;

	@GetMapping(value = "/candidate", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Candidate> viewInterviewCandidates() {
      return techService.viewInterviewCandidates();
	}

	@PutMapping(value = "/interview/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Interview giveTechRating(@PathVariable("id") int id,
			@RequestBody Interview interview) {
		return techService.giveTechRating(id, interview);
		
	}

	@GetMapping(value = "/candidate/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Candidate getCandidateById(@PathVariable("id") int id) {
		return techService.getCandidateById(id);

	}


	@DeleteMapping(value = "/tech/{id}")
	public boolean resignTechPanelMember(@PathVariable("id") int id) {
		return techService.resignTechPanelMember(id);
		
	}


	@PostMapping(value = "/candidate/entry", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Candidate addCandidate(@RequestBody Candidate candidate) {
		return techService.addCandidate(candidate);
		
	}

	
	@PostMapping(value = "/schedule/entry", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Interview scheduleInterview(@RequestBody Interview interviewSchedule) {
		return techService.scheduleInterview(interviewSchedule);
		
	}


	@GetMapping(value = "/interview", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Interview> viewInterviewSchedules() {
		return techService.viewInterviewSchedules();
		
	}
}


