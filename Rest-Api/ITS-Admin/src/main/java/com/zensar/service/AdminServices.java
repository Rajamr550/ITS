package com.zensar.service;

import java.util.List;

import com.zensar.dto.Candidate;
import com.zensar.dto.PanelMember;

public interface AdminServices {

	public Candidate registerCandidate(Candidate candidate);

	public List<Candidate> getAllCandidates();

	public Candidate getCandidateById(int id);

	public PanelMember addPanelMember(PanelMember panelMember);

}
