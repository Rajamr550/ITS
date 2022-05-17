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

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import com.zensar.dto.InterviewDto;
import com.zensar.service.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")

public class AdminController {
    @Autowired
    AdminServices adminService;

    @PostMapping(value = "/share/tech/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
	    MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "shareDataWithTech", notes = "This api will map the tech id with candidate id for the interview")

    public String shareCandidateWithTech(@PathVariable("id") int id) {
	return adminService.shareCandidateWithTech(id);
    }

    @PostMapping(value = "/interview", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "createInterview", notes = "This api will create a new interview")

    public InterviewDto createInterview(@RequestBody InterviewDto interviewDto) {
	return adminService.createInterview(interviewDto);
    }

    @DeleteMapping(value = "/interview/{id}")
    @ApiOperation(value = "deleteInterviewByID", notes = "This REST API Deletes an interview by id")

    public boolean deleteInterviewByID(@PathVariable("id") int id) {
	return adminService.deleteInterviewByID(id);
    }
}