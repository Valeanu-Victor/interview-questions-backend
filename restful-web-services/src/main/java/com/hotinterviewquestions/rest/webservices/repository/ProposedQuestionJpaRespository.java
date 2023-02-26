package com.hotinterviewquestions.rest.webservices.repository;

import com.hotinterviewquestions.rest.webservices.entity.ProposedQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposedQuestionJpaRespository extends JpaRepository<ProposedQuestion, Long> {

}
