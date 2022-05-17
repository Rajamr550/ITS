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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.Candidate;
import com.zensar.dto.InterviewSchedule;
import com.zensar.dto.PanelMember;
import com.zensar.service.AdminServices;

//import io.swagger.annotations.ApiOperation;


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
	
	
	
	//raja
    //services-3,4,6

	
    @PostMapping(value = "/share/tech/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
    	    MediaType.APPLICATION_XML_VALUE })
//        @ApiOperation(value = "shareDataWithTech", notes = "This api will map the tech id with candidate id for the interview")

        public String shareCandidateWithTech(@PathVariable("id") int id) {
    	return adminServices.shareCandidateWithTech(id);
        }

        @PostMapping(value = "/interview", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//        @ApiOperation(value = "createInterview", notes = "This api will create a new interview")

        public InterviewSchedule createInterview(@RequestBody InterviewSchedule interviewDto) {
    	return adminServices.createInterviewSchedule(interviewDto);
        }

        @DeleteMapping(value = "/interview/{id}")
//        @ApiOperation(value = "deleteInterviewByID", notes = "This REST API Deletes an interview by id")

        public boolean deleteInterviewByID(@PathVariable("id") int id) {
    	return adminServices.deleteInterviewScheduleByID(id);
        }
	
	      //8
      		@GetMapping(value="/panel/search",consumes= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
      		public List<PanelMember>searchEmployee(@RequestParam(name="id",required=false)Integer id,
      				@RequestParam(name="name",required=false)String name){
      			return adminServices.searchEmployee(id,name);
      		}
	
	//9.1
      	@DeleteMapping(value = "/panel/tech/{id}")
      	public boolean deleteTechMember(@PathVariable("id") int id) {
      		return adminServices.deleteTechMember(id);
      	}
      	//9.2
      	@DeleteMapping(value = "/panel/hr/{id}")
      	public boolean deleteHRMember(@PathVariable("id") int id) {
      		return adminServices.deleteHRMember(id);
      	}
      	
      	//10
      	@GetMapping(value = "/panel", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
      	public List<PanelMember> getAllPanelMembers(){
      		return adminServices.getAllPanelMembers();
      	}
	
	
	
	
	
	
}
