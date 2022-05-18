package com.zensar.service;

import java.util.List;

import com.zensar.dto.Candidate;
import com.zensar.dto.Interview;


public interface TechService {
	public List<Candidate> viewInterviewCandidates(String authToken);
	public Interview giveTechRating(int id, Interview interview, String authToken);
	public Candidate getCandidateById(int id, String authToken);
	public boolean resignTechPanelMember(int id, String authToken);
	public Candidate addCandidate(Candidate candidate);
	public Interview scheduleInterview(Interview interviewSchedule);
	public List<Interview> viewInterviewSchedules();
	

}
