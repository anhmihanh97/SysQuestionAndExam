package com.cmcglobal.service;

import com.cmcglobal.entity.Candidate;
import com.cmcglobal.entity.CandidateTest;
import com.cmcglobal.entity.Test;

public interface CandidateTestService {
	CandidateTest insertCandidateTest(CandidateTest candidateTest);

	CandidateTest getOne(int id);
	
	CandidateTest getCandidateTestByCandidateAndTest(Candidate candidate, Test test);
	
	boolean isExistCandidateTest(int candidateId, int testId);
}
