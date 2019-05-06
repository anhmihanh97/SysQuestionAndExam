package com.cmcglobal.service;

import java.util.List;
import java.util.Optional;

import com.cmcglobal.entity.Candidate;

public interface CandidateService {

	public List<Candidate> findAllCandidate();

	public ServiceResult insertCandidate(Candidate candidate);

	public ServiceResult deleteCandidate(Integer id);

	public Optional<Candidate> findByCandidateID(Integer id);

	public List<Candidate> findBySemesterID(String id);

	public Candidate getCandidatetById(String semesterId, String candidateID);

	public Candidate getCandidateByUserIdAndSemesterId(int userId, String semesterId);

}