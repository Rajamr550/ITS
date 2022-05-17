package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.CandidateEntity;
import com.zensar.entity.PanelMemberEntity;
import com.zensar.entity.InterviewScheduleEntity;

import com.zensar.repo.CandidateRepo;
import com.zensar.repo.PanelMemberRepo;
import com.zensar.repo.InterviewScheduleRepo;

import com.zensar.dto.*;

@Service
public class AdminServiceImpl implements AdminServices {

	@Autowired
	CandidateRepo candidateRepo;

	@Autowired
	PanelMemberRepo panelMemberRepo;

	@Autowired
	InterviewScheduleRepo interviewScheduleRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	PanelServiceDelegate panelServiceDelegate;

	// utils - methods
	private Candidate convertEntityintoDTOForCandidate(CandidateEntity candidateEntity) {

		Candidate candidate = modelMapper.map(candidateEntity, Candidate.class);
		return candidate;
	}

	private CandidateEntity convertDTOintoEntityForCandidate(Candidate candidate) {

		CandidateEntity candidateEntity = modelMapper.map(candidate, CandidateEntity.class);
		return candidateEntity;
	}

	// utils
	private InterviewScheduleEntity convertDTOIntoEntityForInterviewSchedule(InterviewSchedule interviewScheduleDto) {
		TypeMap<InterviewSchedule, InterviewScheduleEntity> tMap = modelMapper.typeMap(InterviewSchedule.class,
				InterviewScheduleEntity.class);
		InterviewScheduleEntity interviewScheduleEntity = modelMapper.map(interviewScheduleDto,
				InterviewScheduleEntity.class);
		return interviewScheduleEntity;
	}

	private InterviewSchedule convertEntityIntoDTOForInterviewScheduleSchedule(
			InterviewScheduleEntity interviewScheduleEntity) {
		TypeMap<InterviewScheduleEntity, InterviewSchedule> tMap = modelMapper.typeMap(InterviewScheduleEntity.class,
				InterviewSchedule.class);
		InterviewSchedule interviewScheduleDto = modelMapper.map(interviewScheduleEntity, InterviewSchedule.class);
		return interviewScheduleDto;
	}

	@Override
	public Candidate registerCandidate(Candidate candidate) {
		CandidateEntity candidateEntity = convertDTOintoEntityForCandidate(candidate);
		candidateEntity = candidateRepo.save(candidateEntity);

		return convertEntityintoDTOForCandidate(candidateEntity);
	}

	// logic
	@Override
	public List<Candidate> getAllCandidates() {

		List<CandidateEntity> candidateEntityList = candidateRepo.findAll();
		List<Candidate> candidateDtoList = new ArrayList<Candidate>();
		for (CandidateEntity candidateEntity : candidateEntityList) {

			Candidate candidate = convertEntityintoDTOForCandidate(candidateEntity);
			candidateDtoList.add(candidate);
		}
		return candidateDtoList;
	}

	@Override
	public Candidate getCandidateById(int id) {

		Optional<CandidateEntity> opCandidateEntity = candidateRepo.findById(id);
		if (opCandidateEntity.isPresent()) {
			CandidateEntity candidateEntity = opCandidateEntity.get();
			return convertEntityintoDTOForCandidate(candidateEntity);
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

	// change method name
	@Override
	public String shareCandidateWithTech(int interviewScheduleId) {

		InterviewScheduleEntity interviewScheduleEntity2 = interviewScheduleRepo.getById(interviewScheduleId);

		int candidateId = interviewScheduleEntity2.getCandidateId();
		CandidateEntity candidateEntity2 = candidateRepo.getById(candidateId);

		if (candidateEntity2 != null && interviewScheduleEntity2 != null) {
			// delegate
			panelServiceDelegate.shareCandidateWithPanel(convertEntityintoDTOForCandidate(candidateEntity2));

			panelServiceDelegate
					.shareScheduleWithPanel(convertEntityIntoDTOForInterviewScheduleSchedule(interviewScheduleEntity2));
			return "data shared successfully";

		}
		return "data shared failed";
	}

	@Override
	public InterviewSchedule createInterviewSchedule(InterviewSchedule interviewScheduleDto) {

		interviewScheduleRepo.save(convertDTOIntoEntityForInterviewSchedule(interviewScheduleDto));
		return interviewScheduleDto;
	}

	@Override
	public boolean deleteInterviewScheduleByID(int id) {
		if (interviewScheduleRepo.existsById(id)) {
			interviewScheduleRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<PanelMember> getAllPanelMembers() {
		List<PanelMemberEntity> panelMemberEntity = panelMemberRepo.findAll();
		List<PanelMember> panelMember =new ArrayList<PanelMember>();
		Iterator<PanelMemberEntity> itrPanelEntities = panelMemberEntity.iterator();
		while(itrPanelEntities.hasNext())
		{
			PanelMember panels = convertEntityIntoDTO(itrPanelEntities.next());
			panelMember.add(panels);
		}
		
		
		return panelMember;
	}
@Override
	public boolean deleteTechMember(int id) {
		 
			if(panelMemberRepo.existsById(id)) {
				if(panelMemberRepo.getById(id).getType().equalsIgnoreCase("Tech")) {
					panelMemberRepo.deleteById(id);
				return true;
			}
				return false;
			}
			return false;
	}

	@Override
	public boolean deleteHRMember(int id) {
		
		if(panelMemberRepo.existsById(id)) {
			if(panelMemberRepo.getById(id).getType().equalsIgnoreCase("HR")) {
				panelMemberRepo.deleteById(id);
			return true;
		}
		return false;
}
		return false;
	}

	
}

