package com.cmcglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cmcglobal.entity.QuestionTag;
@Repository
public interface QuestionTagRepository extends JpaRepository<QuestionTag, Integer>{

}
