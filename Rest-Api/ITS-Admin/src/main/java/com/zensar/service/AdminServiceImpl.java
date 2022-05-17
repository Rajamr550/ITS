package com.zensar.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Candidate;
import com.zensar.entity.CandidateEntity;
import com.zensar.repo.CandidateRepo;

@Service
public class AdminServiceImpl implements AdminServices{

	
	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	ModelMapper modelMapper;
	

	
	
	@Override
	public Candidate registerCandidate(Candidate candidate) {
		CandidateEntity candidateEntity = convertDTOintoEntity(candidate);
		candidateEntity = candidateRepo.save(candidateEntity);

		return convertEntityintoDTO(candidateEntity);
	}

	private Candidate convertEntityintoDTO(CandidateEntity candidateEntity) {

		Candidate candidate = modelMapper.map(candidateEntity, Candidate.class);
		return candidate;
	}

	private CandidateEntity convertDTOintoEntity(Candidate candidate) {

		CandidateEntity candidateEntity = modelMapper.map(candidate, CandidateEntity.class);
		return candidateEntity;
	}
}
