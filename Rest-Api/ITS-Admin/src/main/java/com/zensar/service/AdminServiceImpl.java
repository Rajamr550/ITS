package com.zensar.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.Candidate;
import com.zensar.dto.InterviewSchedule;
import com.zensar.dto.PanelMember;
import com.zensar.entity.CandidateEntity;
import com.zensar.entity.InterviewScheduleEntity;
import com.zensar.entity.PanelMemberEntity;
import com.zensar.repo.CandidateRepo;
import com.zensar.repo.InterviewScheduleRepo;
import com.zensar.repo.PanelMemberRepo;

@Service
public class AdminServiceImpl implements AdminServices {

	@Autowired
	EntityManager entityManager;
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
		List<PanelMember> panelMember = new ArrayList<PanelMember>();
		Iterator<PanelMemberEntity> itrPanelEntities = panelMemberEntity.iterator();
		while (itrPanelEntities.hasNext()) {
			PanelMember panels = convertEntityIntoDTO(itrPanelEntities.next());
			panelMember.add(panels);
		}

		return panelMember;
	}

	@Override
	public boolean deleteTechMember(int id) {

		if (panelMemberRepo.existsById(id)) {
			if (panelMemberRepo.getById(id).getType().equalsIgnoreCase("Tech")) {
				panelMemberRepo.deleteById(id);
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean deleteHRMember(int id) {

		if (panelMemberRepo.existsById(id)) {
			if (panelMemberRepo.getById(id).getType().equalsIgnoreCase("HR")) {
				panelMemberRepo.deleteById(id);
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public List<PanelMember> searchEmployee(Integer id, String name) {
		CriteriaBuilder critertiaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<PanelMemberEntity> criteriaQuery = critertiaBuilder.createQuery(PanelMemberEntity.class);
		Root<PanelMemberEntity> rootEntity = criteriaQuery.from(PanelMemberEntity.class);

		Predicate predicateId = critertiaBuilder.and();
		Predicate predicateName = critertiaBuilder.and();
		Predicate predicateFinal = critertiaBuilder.and();

		if (name != null && !"".equalsIgnoreCase(name)) {
			predicateName = critertiaBuilder.like(rootEntity.get("name"), "%" + name + "%");

		}
		if (id != null) {
			predicateId = critertiaBuilder.equal(rootEntity.get("employeeId"), id);
		}

		predicateFinal = critertiaBuilder.and(predicateId, predicateName);
		criteriaQuery.where(predicateFinal);

		TypedQuery<PanelMemberEntity> typedQuery = entityManager.createQuery(criteriaQuery);
		List<PanelMemberEntity> panelEntityList = typedQuery.getResultList();
		// write a convert and return advertise list here
		List<PanelMember> panelList = new ArrayList<>();
		for (PanelMemberEntity p : panelEntityList)
			panelList.add(convertEntityIntoDTO(p));

		return panelList;
	}

}
