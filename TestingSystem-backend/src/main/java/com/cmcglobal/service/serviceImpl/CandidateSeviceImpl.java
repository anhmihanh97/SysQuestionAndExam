package com.cmcglobal.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmcglobal.entity.Candidate;
import com.cmcglobal.repository.CandidateRepository;
import com.cmcglobal.service.CandidateService;
import com.cmcglobal.service.ServiceResult;
import com.cmcglobal.service.ServiceResult.Status;

@Service
@Transactional
public class CandidateSeviceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

    /* (non-Javadoc)
     * @see com.cmcglobal.service.CandidateService#findAllCandidate()
     */
    @Override
    public List<Candidate> findAllCandidate() {
        return candidateRepository.findAll();
    }

    /* (non-Javadoc)
     * @see com.cmcglobal.service.CandidateService#insertCandidate(com.cmcglobal.entity.Candidate)
     */
    @Override
    public ServiceResult insertCandidate(Candidate candidate) {
        ServiceResult result = new ServiceResult();
        result.setData(candidateRepository.save(candidate));
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcglobal.service.CandidateService#deleteCandidate(java.lang.Integer)
     */
    @Override
    public ServiceResult deleteCandidate(Integer id) {
        ServiceResult result = new ServiceResult();
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate == null) {
            result.setMessage("Not Found object");
            result.setStatus(Status.FAILED);
        } else {
            candidateRepository.delete(candidate);
            result.setStatus(Status.SUCCESS);
            result.setData(candidateRepository.findAll());
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.cmcglobal.service.CandidateService#findByCandidateID(java.lang.Integer)
     */
    @Override
    public Optional<Candidate> findByCandidateID(Integer id) {
        return candidateRepository.findById(id);
    }

    @Override
    public List<Candidate> findBySemesterID(String id) {
        try {
            List<Candidate> test = candidateRepository.findAll();
            List<Candidate> test2 = new ArrayList<>();
            for (Candidate test3 : test) {
                if (test3.getSemesterExam().getId().equals(id)) {
                    test2.add(test3);
                }
            }
            return test2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public Candidate getCandidatetById(String semesterId, String candidateID) {
		List<Candidate> list = findBySemesterID(semesterId);
		for (Candidate candidate : list) {
			if (candidateID.equals(candidate.getSemesterExam().getId()))
				return candidate;
		}
		return null;
	}

	@Override
	public Candidate getCandidateByUserIdAndSemesterId(int userId, String semesterId) {
		List<Candidate> list = candidateRepository.findAll();
		for (Candidate candidate : list) {
			if (candidate.getUser().getUserId() == userId && candidate.getSemesterExam().getId().equals(semesterId)) {
				return candidate;
			}
		}
		return null;
	}

}
