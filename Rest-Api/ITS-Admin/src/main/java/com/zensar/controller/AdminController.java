/*
 * post
 * 	adding - candidate,interview,hr,tech
 * 
 * get
 * 	view - candidate,hr,tech
 * 	8.search rmployee by id or name[custom repo]
 * 	3.share the candidates
 * 		switch("tech")
 * 			[candidateId ---> techId]
 * 			hashmap[canId,techId];
 * 			
 * 
 * put
 * 	priority -2
 * 	
 * 
 * Delete
 *    cancel interview
 *    delete panel members
 *    
 *    
 *Priroity - 2
 *	listing all the interview list - get
 *	delete candidate - delete
 *	
 *
 *other endpoints 
 *	getByCandidateId(id)
 * 
 * 
 * 
 * 
 * 
 * 
 */

package com.zensar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Candidate;
import com.zensar.dto.PanelMember;
import com.zensar.service.AdminServices;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="*")
public class AdminController {

	@Autowired
	AdminServices adminServices;
	
	//1--Register a candidate
	@PostMapping(value="/candidate", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Candidate registerCandidate(@RequestBody Candidate candidate) {
		return adminServices.registerCandidate(candidate);
	}
	
	//2.1-- View All Candidate 
	@GetMapping(value="/candidate", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Candidate> getAllCandidates(){
		return adminServices.getAllCandidates();
	}
	
	//2.2 -- View a candidate By Id
	@GetMapping(value="/candidate/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Candidate getCandidateById(@PathVariable("id") int id){
		return adminServices.getCandidateById(id);
	}
	
	//7 -- Adding Panel Members
	@PostMapping(value="/panel", consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public PanelMember addPanelMember(@RequestBody PanelMember panelMember) {
		return adminServices.addPanelMember(panelMember);
	}
	
	
	
	
	
	
	
	
	
	
	
}
