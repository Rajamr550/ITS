package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Candidate;
import com.zensar.dto.Interview;
import com.zensar.entity.CandidateEntity;
import com.zensar.entity.InterviewEntity;
import com.zensar.repo.CandidateRepo;
import com.zensar.repo.InterviewRepo;

@Service
public class TechServiceImpl implements TechService{
	
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CandidateRepo candidateRepo;
	@Autowired
	InterviewRepo interviewRepo;
	@Autowired
	AdminServiceDelegate adminServiceDelgate;
	@Autowired
	UserServiceDelegate userServiceDelegate;

	@Override
	public List<Candidate> viewInterviewCandidates(String authToken) {
		List<CandidateEntity> candidateEntity = candidateRepo.findAll();
		List<Candidate> candidateList = new ArrayList<>();
			for(CandidateEntity candidates: candidateEntity)
				candidateList.add(convertCandidateEntityIntoDto(candidates));
		return candidateList;
	}

	@Override
	public Interview giveTechRating(int id, Interview interview, String authToken) {
		Optional<InterviewEntity> optionalInterviewEntity = interviewRepo.findById(id);
		if(optionalInterviewEntity.isPresent()) {
			InterviewEntity interviewEntity = optionalInterviewEntity.get();
			interviewEntity.setTechRating(interview.getTechRating());
			interviewRepo.save(interviewEntity);
			return convertInterviewEntityIntoDto(interviewEntity);
		}
		return null;
	}

	@Override
	public Candidate getCandidateById(int id, String authToken) {
		Optional<CandidateEntity> candidateId=candidateRepo.findById(id);
		if(candidateId.isPresent()) {
		return convertCandidateEntityIntoDto(candidateId.get());
		}
		return null;
	}

	@Override
	public boolean resignTechPanelMember(int id, String authToken) {
		if(userServiceDelegate.isTokenValid(authToken)) {
			return adminServiceDelgate.isDeleteSuccessful(id);
		}
		return false;
	}

	@Override
	public Candidate addCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interview scheduleInterview(Interview interviewSchedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Interview> viewInterviewSchedules() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private CandidateEntity convertCandidateDtoIntoEntity(Candidate candidate) {
		CandidateEntity candidateEntity=modelMapper.map(candidate, CandidateEntity.class);
		return candidateEntity;
		}



		private Candidate convertCandidateEntityIntoDto(CandidateEntity candidateEntity) {
		Candidate candidate=modelMapper.map(candidateEntity, Candidate.class);
		return candidate;
		}
		
		private Interview convertInterviewEntityIntoDto(InterviewEntity interviewEntity) {
			Interview interview=modelMapper.map(interviewEntity, Interview.class);
			return interview;
		}
		private InterviewEntity convertInterviewDtoIntoEntity(Interview interview) {
			InterviewEntity interviewEntity=modelMapper.map(interview, InterviewEntity.class);
			return interviewEntity;
		}

}
