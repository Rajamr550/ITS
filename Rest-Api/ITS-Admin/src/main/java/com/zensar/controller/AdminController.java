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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Candidate;
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
}
