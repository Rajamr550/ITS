package com.zensar.service;

import java.util.List;

import com.zensar.dto.Candidate;
import com.zensar.dto.InterviewSchedule;
import com.zensar.dto.PanelMember;

public interface AdminServices {

	public Candidate registerCandidate(Candidate candidate);

	public List<Candidate> getAllCandidates();

	public Candidate getCandidateById(int id);

	public PanelMember addPanelMember(PanelMember panelMember);

	public String shareCandidateWithTech(int id);



	InterviewSchedule createInterviewSchedule(InterviewSchedule interviewScheduleDto);

	boolean deleteInterviewScheduleByID(int id);
        
	public List<PanelMember> searchEmployee(Integer id, String name);

//<<<<<<< HEAD
//	boolean deleteHRMember(int id);
//
//	boolean deleteTechMember(int id);
//
//	public List<PanelMember> getAllPanelMembers();
//
//=======
//	public List<PanelMember> getAllPanelMembers();
//>>>>>>> branch 'main' of https://github.com/Rajamr550/ITS.git
//
//	public boolean deleteTechMember(int id);
//
//	public boolean deleteHRMember(int id);
	
}
