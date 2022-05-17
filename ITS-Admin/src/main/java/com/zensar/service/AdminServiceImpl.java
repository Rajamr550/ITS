package com.zensar.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zensar.dto.InterviewDto;
import com.zensar.entity.InterviewEntity;
import com.zensar.repo.CandidateRepo;
import com.zensar.repo.EmployeeRepo;
import com.zensar.repo.InterviewRepo;

@Service
@Qualifier(value = "admin-serivce")
public class AdminServiceImpl implements AdminServices {

    @Autowired
    InterviewRepo interviewRepo;

    @Autowired
    CandidateRepo candidateRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String shareCandidateWithTech(int interviewId) {

	return null;
    }

    @Override
    public InterviewDto createInterview(InterviewDto interviewDto) {

	interviewRepo.save(convertDTOIntoEntity(interviewDto));
	return interviewDto;
    }

    @Override
    public boolean deleteInterviewByID(int id) {
	if (interviewRepo.existsById(id)) {
	    interviewRepo.deleteById(id);
	    return true;
	}
	return false;
    }

    // utils
    private InterviewEntity convertDTOIntoEntity(InterviewDto interviewDto) {
	TypeMap<InterviewDto, InterviewEntity> tMap = modelMapper.typeMap(InterviewDto.class, InterviewEntity.class);
	InterviewEntity interviewEntity = modelMapper.map(interviewDto, InterviewEntity.class);
	return interviewEntity;
    }

    private InterviewDto convertEntityIntoDTO(InterviewEntity interviewEntity) {
	TypeMap<InterviewEntity, InterviewDto> tMap = modelMapper.typeMap(InterviewEntity.class, InterviewDto.class);
	InterviewDto interviewDto = modelMapper.map(interviewEntity, InterviewDto.class);
	return interviewDto;
    }

}
