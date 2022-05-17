package com.zensar.service;

import java.util.List;

import com.zensar.dto.Candidate;
import com.zensar.dto.Interview;


public interface TechService {
	public List<Candidate> viewInterviewCandidates();
	public Interview giveTechRating(int id, Interview interview);
	public Candidate getCandidateById(int id);
	public boolean resignTechPanelMember(int id);
	public Candidate addCandidate(Candidate candidate);
	public Interview scheduleInterview(Interview interviewSchedule);
	public List<Interview> viewInterviewSchedules();

}
