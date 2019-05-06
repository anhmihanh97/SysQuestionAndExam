package com.cmcglobal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmcglobal.entity.Candidate;
import com.cmcglobal.service.CandidateService;
import com.cmcglobal.service.ServiceResult;
import com.cmcglobal.utils.Api;

@RestController
@RequestMapping(Api.Candidate.API_URL_CANDIDATE_START)
@CrossOrigin(origins = Api.BASE_URL_CORS, maxAge = 3600)
public class CandidateController {

    @Autowired
    private CandidateService candidateService;
    
    
    @GetMapping(value = Api.Candidate.API_URL_LIST_CANDIDATE)
    public List<Candidate> ListCandidate() {
        return candidateService.findAllCandidate();
    }

    @GetMapping(value = Api.Candidate.API_URL_LIST_CANDIDATE_ID)
    public Optional<Candidate> ListByCandidateID(Integer id) {
        return candidateService.findByCandidateID(id);
    }

    @GetMapping(value = Api.Candidate.API_URL_LIST_BY_SEMESTER_ID)
    public List<Candidate> listBySemester(@PathVariable("id") String id) {
        return candidateService.findBySemesterID(id);
    }

    @PostMapping(value = Api.Candidate.API_URL_ADD_CANDIDATE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> insertCandidate(@RequestBody Candidate candidate) {
        return new ResponseEntity<ServiceResult>(candidateService.insertCandidate(candidate), HttpStatus.OK);
    }

    @DeleteMapping(value = Api.Candidate.API_URL_DELETE_CANDIDATE)
    public ResponseEntity<ServiceResult> deleteCandidate(@PathVariable Integer id) {
        return new ResponseEntity<ServiceResult>(candidateService.deleteCandidate(id), HttpStatus.OK);
    }
}
