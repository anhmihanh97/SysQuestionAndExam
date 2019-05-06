package com.cmcglobal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cmcglobal.entity.QuestionLevel;
@Repository
public interface QuestionLevelRepository extends JpaRepository<QuestionLevel, Integer>{

}
