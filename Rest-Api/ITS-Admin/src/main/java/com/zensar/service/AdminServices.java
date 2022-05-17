package com.zensar.service;

import java.util.List;

import com.zensar.dto.Candidate;

public interface AdminServices {

	public Candidate registerCandidate(Candidate candidate);

	public List<Candidate> getAllCandidates();

	public Candidate getCandidateById(int id);

}
