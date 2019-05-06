package com.cmcglobal.service.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcglobal.entity.Candidate;
import com.cmcglobal.entity.CandidateTest;
import com.cmcglobal.entity.Test;
import com.cmcglobal.repository.CandidateTestRepository;
import com.cmcglobal.service.CandidateTestService;

@Service
@Transactional
public class CandidateTestServiceImpl implements CandidateTestService {
	@Autowired
	private CandidateTestRepository candidateTestRepository;

	@Override
	public CandidateTest insertCandidateTest(CandidateTest candidateTest) {
		return candidateTestRepository.save(candidateTest);
	}

	@Override
	public CandidateTest getOne(int id) {
		return candidateTestRepository.getOne(id);
	}

	@Override
	public CandidateTest getCandidateTestByCandidateAndTest(Candidate candidate, Test test) {
		List<CandidateTest> list = candidateTestRepository.findAll();
		for (CandidateTest candidateTest : list) {
			if (candidateTest.getCandidates().getId() == candidate.getId()
					&& candidateTest.getTests().getTestID() == test.getTestID()) {
				return candidateTest;
			}
		}
		return null;
	}

	@Override
	public boolean isExistCandidateTest(int candidateId, int testId) {
		List<CandidateTest> list = candidateTestRepository.findAll();
		for (CandidateTest item : list) {
			if(item.getCandidates().getId() == candidateId && item.getTests().getTestID() ==testId) {
				return true;
			}
		}
		return false;
	}

}
