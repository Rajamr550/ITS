package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Candidate;
import com.zensar.dto.PanelMember;
import com.zensar.entity.CandidateEntity;
import com.zensar.entity.PanelMemberEntity;
import com.zensar.repo.CandidateRepo;
import com.zensar.repo.PanelMemberRepo;

@Service
public class AdminServiceImpl implements AdminServices{

	
	@Autowired
	CandidateRepo candidateRepo;
	
	@Autowired
	PanelMemberRepo panelMemberRepo;
	
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

	@Override
	public List<Candidate> getAllCandidates() {
		
		List<CandidateEntity> candidateEntityList =candidateRepo.findAll();
		List<Candidate> candidateDtoList=new ArrayList<Candidate>();
		for(CandidateEntity candidateEntity : candidateEntityList) {
			
			Candidate candidate=convertEntityintoDTO(candidateEntity);
			candidateDtoList.add(candidate);
		}
		return  candidateDtoList;
	}

	@Override
	public Candidate getCandidateById(int id) {
		
		Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(id);
		if(opCandidateEntity.isPresent()) {
		CandidateEntity candidateEntity=opCandidateEntity.get();
		return convertEntityintoDTO(candidateEntity);
		}
		return null;
	}

	@Override
	public PanelMember addPanelMember(PanelMember panelMember) {
		PanelMemberEntity panelMemberEntity = convertDTOIntoEntity(panelMember);
		panelMemberEntity = panelMemberRepo.save(panelMemberEntity);

		return convertEntityIntoDTO(panelMemberEntity);
	}
	
	private PanelMember convertEntityIntoDTO(PanelMemberEntity panelMemberEntity) {

		PanelMember panelMember = modelMapper.map(panelMemberEntity, PanelMember.class);
		return panelMember;
	}

	private PanelMemberEntity convertDTOIntoEntity(PanelMember panelMember) {

		PanelMemberEntity panelMemberEntity = modelMapper.map(panelMember, PanelMemberEntity.class);
		return panelMemberEntity;
	}
}
