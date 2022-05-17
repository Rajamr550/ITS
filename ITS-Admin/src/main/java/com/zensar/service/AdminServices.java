package com.zensar.service;

import com.zensar.dto.InterviewDto;

public interface AdminServices {

    public String shareCandidateWithTech(int id);

    public InterviewDto createInterview(InterviewDto interviewDto);

    public boolean deleteInterviewByID(int id);

}
