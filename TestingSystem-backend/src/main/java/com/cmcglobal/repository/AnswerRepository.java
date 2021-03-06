package com.cmcglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, String> {

}
